<%@ include file="/init.jsp" %>

<%
List<Repository> repositories = (List<Repository>)request.getAttribute(GitHubAutomatorWebKeys.GITHUB_REPOSITORIES);

for (Repository repository : repositories) {
	User owner = repository.getOwner();
%>

	<div class="card-horizontal list-group-item">
		<div class="card-row card-row-layout-fixed">
			<div class="card-col-field" style="width:60px;">
				<img alt="user-avatar" class="img-responsive img-rounded" src="<%= owner.getAvatarUrl() %>" />
			</div>
			<div class="card-col-content card-col-gutters list-group-item-content">

				<%
				String repositoryName = HtmlUtil.escape(repository.getName());
				%>

				<h4 title="<%= repositoryName %>">
					<strong><%= repositoryName %></strong>
				</h4>

				<%
				String repositoryDescription = HtmlUtil.escape(repository.getDescription());
				%>

				<c:if test="<%= Validator.isNotNull(repositoryDescription) %>">
					<h5 class="text-default truncate-text"><%= repositoryDescription %></h5>
				</c:if>

				<div style="margin-bottom: -20px;">
					<aui:input iconOff="icon-remove" iconOn="icon-ok" label="" labelOff="" labelOn="" name='<%= repository.getId() + "enable" %>' type="toggle-switch" />
				</div>
			</div>

			<div class="card-col-field lfr-card-actions-column">
				<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>" triggerCssClass="text-default">
					<portlet:actionURL name="/github_automator/add_hook" var="addHookURL">
						<portlet:param name="name" value="<%= repository.getName() %>" />
						<portlet:param name="owner" value="<%= owner.getLogin() %>" />
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