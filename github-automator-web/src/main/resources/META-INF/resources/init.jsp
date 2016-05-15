<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.github.automator.web.constants.GitHubAutomatorWebKeys" %><%@
page import="com.liferay.github.automator.web.model.view.GitHubRepositoryModelView" %><%@
page import="com.liferay.github.automator.web.model.view.GitHubTaskModelView" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %>

<%@ page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<portlet:defineObjects />