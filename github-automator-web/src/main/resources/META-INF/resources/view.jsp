<%@ include file="/init.jsp" %>

<%
String navigation = ParamUtil.getString(request, "navigation", "owner");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", "/github_automator/view");
portletURL.setParameter("navigation", navigation);
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<portlet:renderURL var="viewOwnRepositoriesURL" />

		<aui:nav-item
			href="<%= viewOwnRepositoriesURL %>"
			label="my-repositories"
			selected='<%= navigation.equals("owner") %>'
		/>

		<portlet:renderURL var="viewCollaboratorRepositoriesURL">
			<portlet:param name="navigation" value="collaborator" />
		</portlet:renderURL>

		<aui:nav-item
			href="<%= viewCollaboratorRepositoriesURL %>"
			label="collaborator-repositories"
			selected='<%= navigation.equals("collaborator") %>'
		/>

		<portlet:renderURL var="viewOrganizationMemberRepositoriesURL">
			<portlet:param name="navigation" value="organization_member" />
		</portlet:renderURL>

		<aui:nav-item
			href="<%= viewOrganizationMemberRepositoriesURL %>"
			label="organization-repositories"
			selected='<%= navigation.equals("organization_member") %>'
		/>
	</aui:nav>

	<aui:form action="<%= portletURL.toString() %>" name="searchFm">
		<aui:nav-bar-search>
			<liferay-ui:input-search markupView="lexicon" />
		</aui:nav-bar-search>
	</aui:form>
</aui:nav-bar>

<%
List<GitHubRepositoryModelView> gitHubRepositoryModelViews = (List<GitHubRepositoryModelView>)request.getAttribute(GitHubAutomatorWebKeys.GITHUB_REPOSITORY_MODEL_VIEWS);

for (GitHubRepositoryModelView gitHubRepositoryModelView : gitHubRepositoryModelViews) {
%>

	<div class="card-horizontal list-group-item">
		<div class="card-row card-row-layout-fixed">
			<div class="card-col-field" style="width:60px;">
				<img alt="user-avatar" class="img-responsive img-rounded" src="<%= gitHubRepositoryModelView.getOwnerAvatarURL() %>" />
			</div>
			<div class="card-col-content card-col-gutters list-group-item-content">

				<%
				String repositoryName = HtmlUtil.escape(gitHubRepositoryModelView.getRepositoryName());
				%>

				<h4 title="<%= repositoryName %>">
					<strong><%= repositoryName %></strong>
				</h4>

				<%
				String repositoryDescription = HtmlUtil.escape(gitHubRepositoryModelView.getRepositoryDescription());
				%>

				<c:if test="<%= Validator.isNotNull(repositoryDescription) %>">
					<h5 class="text-default truncate-text"><%= repositoryDescription %></h5>
				</c:if>

				<div style="margin-bottom: -20px;">
					<aui:input iconOff="icon-remove" iconOn="icon-ok" label="" labelOff="" labelOn="" name='<%= gitHubRepositoryModelView.getRepositoryId() + "enable" %>' type="toggle-switch" />
				</div>
			</div>

			<div class="card-col-field lfr-card-actions-column">
				<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="text-default">
					<portlet:actionURL name="/github_automator/add_hook" var="addHookURL">
						<portlet:param name="name" value="<%= gitHubRepositoryModelView.getRepositoryName() %>" />
						<portlet:param name="owner" value="<%= gitHubRepositoryModelView.getOwnerLogin() %>" />
					</portlet:actionURL>

					<liferay-ui:icon
						message="add-hook"
						url="<%= addHookURL %>"
					/>
				</liferay-ui:icon-menu>
			</div>
		</div>
	</div>

<%
}
%>