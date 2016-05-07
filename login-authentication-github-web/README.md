# Login Authentication GitHub Web

This OSGi module allows Liferay Users to sign up and access Liferay Portal using their GitHub account. Liferay will use GitHub OAuth2 protocol to authenticate the user and it will create an account in Liferay Portal using the information provided by GitHub.

This module depends on the following OSGi modules that should also be deployed in Liferay Portal to provide GitHub Login functionality:

* [Portal Security SSO GitHub](https://github.com/sergiogonzalez/github-liferay-suite/tree/master/portal-security-sso-github)

## Configuration

GitHub requires some additional steps before applications can consume their APIs. For this particular case of authenticating using OAuth2 the following steps apply:

* A new GitHub Developer Application needs to be created [here](https://github.com/settings/applications/new). Fill in the required fields (application name, homepage url and application description). The **authorization callback url** needs to be a **publicly accessible url** (not valid localhost or internal ip address or domains) and it needs to have this format: `http://<server-name>/c/portal/github_login?cmd=token`, i.e: `http://www.mycoolapp.com/c/portal/github_login?cmd=token`.

* Once the application is registered, you can view the credentials `Client ID` and `Client Secret`. Those credentials will be necessary when configuring [Portal Security SSO GitHub](https://github.com/sergiogonzalez/github-liferay-suite/tree/master/portal-security-sso-github). 

![Creating a GitHub Application](/readme_images/creating_a_github_application.jpg "Configure Google App")

## How it works?

This module is the `web` module for the GitHub Login functionality. It takes care of including a new GitHub link in the Login Portlet to offer this new login mechanism. The module also takes care of implementing the OAuth2 protocol with GitHub to ensure the authenticity of the user as well as getting some basic data from the user (full name and email address).

This module exposes a public path in `c/portal/github_login` that will be accessed by GitHub as part of the redirect phase of the OAuth2 protocol.
