<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/login/navigation/init.jsp" %>

<%
String gitHubAuthURL = PortalUtil.getPathContext() + "/c/portal/github_login?cmd=login";

String taglibOpenGitHubLoginWindow = "javascript:var gitHubLoginWindow = window.open('" + gitHubAuthURL.toString() + "', 'GitHub', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); gitHubLoginWindow.focus();";
%>

<liferay-ui:icon
	iconCssClass="icon-github"
	message="GitHub"
	url="<%= taglibOpenGitHubLoginWindow %>"
/>