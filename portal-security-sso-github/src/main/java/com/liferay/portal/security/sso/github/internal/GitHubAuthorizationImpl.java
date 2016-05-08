package com.liferay.portal.security.sso.github.internal;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.sso.github.GitHubAuthorization;
import com.liferay.portal.security.sso.github.configuration.GitHubAuthorizationConfiguration;
import com.liferay.portal.security.sso.github.constants.GitHubWebKeys;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.UserService;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(
	configurationPid = "com.liferay.portal.security.sso.github.configuration.GitHubAuthorizationConfiguration",
	immediate = true, service = GitHubAuthorization.class
)
public class GitHubAuthorizationImpl implements GitHubAuthorization {

	@Override
	public User addOrUpdateUser(
			HttpSession session, long companyId, String authorizationCode)
		throws Exception {

		String accessToken = getAccessToken(authorizationCode, session);

		GitHubClient gitHubClient = new GitHubClient();

		gitHubClient.setOAuth2Token(accessToken);

		UserService userService = new UserService(gitHubClient);

		org.eclipse.egit.github.core.User gitHubUser = userService.getUser();

		return doAddOrUpdateUser(session, companyId, gitHubUser);
	}

	@Override
	public String getAccessToken(String code, HttpSession session) {
		String url = HttpUtil.addParameter(
			"https://github.com/login/oauth/access_token", "client_id",
			_gitHubAuthorizationConfiguration.clientId());

		url = HttpUtil.addParameter(
			url, "client_secret",
			_gitHubAuthorizationConfiguration.clientSecret());
		url = HttpUtil.addParameter(url, "code", code);

		Http.Options options = new Http.Options();

		options.setLocation(url);
		options.setPost(true);

		try {
			String content = HttpUtil.URLtoString(options);

			if (Validator.isNotNull(content)) {
				int x = content.indexOf("access_token=");

				if (x >= 0) {
					int y = content.indexOf(CharPool.AMPERSAND, x);

					if (y < x) {
						y = content.length();
					}

					return content.substring(x + 13, y);
				}
			}
		}
		catch (Exception e) {
			throw new SystemException(
				"Unable to retrieve GitHub access token", e);
		}

		return null;
	}

	@Override
	public String getLoginRedirect(String returnRequestUri, List<String> scopes)
		throws Exception {

		StringBundler sb = new StringBundler(7);

		sb.append("https://github.com/login/oauth/authorize");
		sb.append("?client_id=");
		sb.append(_gitHubAuthorizationConfiguration.clientId());
		sb.append("&redirect_uri=");
		sb.append(returnRequestUri);
		sb.append("&scope=");
		sb.append(StringUtil.merge(scopes));

		return sb.toString();
	}

	@Override
	public boolean isEnabled() {
		if (Validator.isNull(_gitHubAuthorizationConfiguration.clientId()) ||
			Validator.isNull(
				_gitHubAuthorizationConfiguration.clientSecret())) {

			return false;
		}

		return _gitHubAuthorizationConfiguration.enabled();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_gitHubAuthorizationConfiguration = ConfigurableUtil.createConfigurable(
			GitHubAuthorizationConfiguration.class, properties);
	}

	protected User addUser(
			long companyId, org.eclipse.egit.github.core.User gitHubUser)
		throws Exception {

		long creatorUserId = 0;
		boolean autoPassword = true;
		String password1 = StringPool.BLANK;
		String password2 = StringPool.BLANK;
		boolean autoScreenName = true;
		String screenName = StringPool.BLANK;
		String emailAddress = gitHubUser.getEmail();
		String openId = StringPool.BLANK;
		Locale locale = LocaleUtil.getDefault();
		String firstName = gitHubUser.getName();
		String middleName = StringPool.BLANK;
		String lastName = gitHubUser.getName();
		long prefixId = 0;
		long suffixId = 0;
		boolean male = true;
		int birthdayMonth = Calendar.JANUARY;
		int birthdayDay = 1;
		int birthdayYear = 1970;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = true;

		ServiceContext serviceContext = new ServiceContext();

		User user = _userLocalService.addUser(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, 0, openId, locale,
			firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);

		user = _userLocalService.updateLastLogin(
			user.getUserId(), user.getLoginIP());

		user = _userLocalService.updatePasswordReset(user.getUserId(), false);

		user = _userLocalService.updateEmailAddressVerified(
			user.getUserId(), true);

		return user;
	}

	protected User doAddOrUpdateUser(
			HttpSession session, long companyId,
			org.eclipse.egit.github.core.User gitHubUser)
		throws Exception {

		User user = null;

		String emailAddress = gitHubUser.getEmail();

		if ((user == null) && Validator.isNotNull(emailAddress)) {
			user = _userLocalService.fetchUserByEmailAddress(
				companyId, emailAddress);

			if ((user != null) &&
				(user.getStatus() != WorkflowConstants.STATUS_INCOMPLETE)) {

				session.setAttribute(
					GitHubWebKeys.GITHUB_USER_EMAIL_ADDRESS, emailAddress);
			}
		}

		if (user != null) {
			if (user.getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
				user.setEmailAddress(gitHubUser.getEmail());
				user.setFirstName(gitHubUser.getName());
				user.setLastName(gitHubUser.getName());

				return user;
			}

			user = updateUser(user, gitHubUser);
		}
		else {
			user = addUser(companyId, gitHubUser);

			session.setAttribute(
				GitHubWebKeys.GITHUB_USER_EMAIL_ADDRESS, emailAddress);
		}

		return user;
	}

	protected User updateUser(
			User user, org.eclipse.egit.github.core.User gitHubUser)
		throws Exception {

		String emailAddress = gitHubUser.getEmail();
		String firstName = gitHubUser.getName();
		String lastName = gitHubUser.getName();
		boolean male = true;

		if (emailAddress.equals(user.getEmailAddress()) &&
			firstName.equals(user.getFirstName()) &&
			lastName.equals(user.getLastName()) && (male == user.isMale())) {

			return user;
		}

		Contact contact = user.getContact();

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();

		birthdayCal.setTime(contact.getBirthday());

		int birthdayMonth = birthdayCal.get(Calendar.MONTH);
		int birthdayDay = birthdayCal.get(Calendar.DAY_OF_MONTH);
		int birthdayYear = birthdayCal.get(Calendar.YEAR);

		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		List<UserGroupRole> userGroupRoles = null;
		long[] userGroupIds = null;

		ServiceContext serviceContext = new ServiceContext();

		if (!StringUtil.equalsIgnoreCase(
				emailAddress, user.getEmailAddress())) {

			_userLocalService.updateEmailAddress(
				user.getUserId(), StringPool.BLANK, emailAddress, emailAddress);
		}

		_userLocalService.updateEmailAddressVerified(user.getUserId(), true);

		return _userLocalService.updateUser(
			user.getUserId(), StringPool.BLANK, StringPool.BLANK,
			StringPool.BLANK, false, user.getReminderQueryQuestion(),
			user.getReminderQueryAnswer(), user.getScreenName(), emailAddress,
			0, user.getOpenId(), true, null, user.getLanguageId(),
			user.getTimeZoneId(), user.getGreeting(), user.getComments(),
			firstName, user.getMiddleName(), lastName, contact.getPrefixId(),
			contact.getSuffixId(), male, birthdayMonth, birthdayDay,
			birthdayYear, contact.getSmsSn(), contact.getFacebookSn(),
			contact.getJabberSn(), contact.getSkypeSn(), contact.getTwitterSn(),
			contact.getJobTitle(), groupIds, organizationIds, roleIds,
			userGroupRoles, userGroupIds, serviceContext);
	}

	private volatile GitHubAuthorizationConfiguration
		_gitHubAuthorizationConfiguration;

	@Reference
	private UserLocalService _userLocalService;

}