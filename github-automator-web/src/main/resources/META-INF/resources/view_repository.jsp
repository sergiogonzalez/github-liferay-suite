<%@ include file="/init.jsp" %>

<%
String repositoryId = ParamUtil.getString(request, "repositoryId");
%>

<portlet:actionURL name="/github_automator/update_repository_task_status" var="updateRepositoryTaskStatusURL" />

<aui:form action="<%= updateRepositoryTaskStatusURL %>">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="repositoryId" type="hidden" value="<%= repositoryId %>" />

	<%
	List<GitHubTaskModelView> gitHubTaskModelViews = (List<GitHubTaskModelView>)request.getAttribute(GitHubAutomatorWebKeys.GITHUB_TASK_MODEL_VIEWS);

	for (GitHubTaskModelView gitHubTaskModelView : gitHubTaskModelViews) {
	%>

		<div class="card-horizontal list-group-item">
			<div class="card-row card-row-layout-fixed">
				<div class="card-col-field" style="width:60px;">
					<img alt="user-avatar" class="img-responsive img-rounded" src="<%= gitHubTaskModelView.getTaskImageURL() %>" />
				</div>
				<div class="card-col-content card-col-gutters list-group-item-content">

					<%
					String repositoryTaskTitle = HtmlUtil.escape(gitHubTaskModelView.getTaskTitle());
					%>

					<h4 title="<%= repositoryTaskTitle %>">
						<strong><%= repositoryTaskTitle %></strong>
					</h4>

					<%
					String repositoryTaskDescription = HtmlUtil.escape(gitHubTaskModelView.getTaskDescription());
					%>

					<c:if test="<%= Validator.isNotNull(repositoryTaskDescription) %>">
						<h5 class="text-default truncate-text"><%= repositoryTaskDescription %></h5>
					</c:if>

					<div style="margin-bottom: -20px;">

						<%
						boolean repositoryTaskEnabled = ParamUtil.getBoolean(request, "repositoryTaskStatus--" + gitHubTaskModelView.getTaskUuid() + "--", gitHubTaskModelView.isEnabled());
						%>

						<aui:input iconOff="icon-remove" iconOn="icon-ok" label="" labelOff="" labelOn="" name='<%= "repositoryTaskStatus--" + gitHubTaskModelView.getTaskUuid() + "--" %>' type="toggle-switch" value="<%= repositoryTaskEnabled %>" />
					</div>
				</div>
			</div>
		</div>

	<%
	}
	%>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" value="save" />
	</aui:button-row>
</aui:form>