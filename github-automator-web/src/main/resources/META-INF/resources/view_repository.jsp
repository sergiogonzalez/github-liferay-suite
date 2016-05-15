<%@ include file="/init.jsp" %>

<%
List<GHAutomatorTask> allTasks = (List<GHAutomatorTask>)request.getAttribute(GitHubAutomatorWebKeys.GITHUB_ALL_TASKS);
%>

<%
for (GHAutomatorTask task : allTasks) {
%>

	<%= task.getUuid() %>

<%
}
%>