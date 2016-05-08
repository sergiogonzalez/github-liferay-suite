<%@ include file="/html/portlet/login/navigation/init.jsp" %>

<%
String gitHubAuthURL = PortalUtil.getPathContext() + "/c" + GitHubLoginConstants.GITHUB_LOGIN_URL + "?cmd=" + GitHubLoginConstants.CMD_LOGIN;

String taglibOpenGitHubLoginWindow = "javascript:var gitHubLoginWindow = window.open('" + gitHubAuthURL.toString() + "', 'GitHub', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); gitHubLoginWindow.focus();";
%>

<liferay-ui:icon
	iconCssClass="icon-github"
	message="GitHub"
	url="<%= taglibOpenGitHubLoginWindow %>"
/>