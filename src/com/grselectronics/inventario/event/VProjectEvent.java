package com.grselectronics.inventario.event;

import com.grselectronics.inventario.views.DashboardViewType;

public abstract class VProjectEvent {
	public static final class UserLoginRequestEvent {
		private final String userEmail, password;

		public UserLoginRequestEvent(final String userEmail, final String password) {
			this.userEmail = userEmail;
			this.password = password;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public String getPassword() {
			return password;
		}
	}

	public static class ProfileUpdatedEvent {
	}

	public static class CloseOpenWindowsEvent {
	}

	public static class UserLoggedOutEvent {

	}

	public static final class PostViewChangeEvent {
		private final DashboardViewType view;

		public PostViewChangeEvent(final DashboardViewType view) {
			this.view = view;
		}

		public DashboardViewType getView() {
			return view;
		}
	}

	public static class BrowserResizeEvent {

	}
}
