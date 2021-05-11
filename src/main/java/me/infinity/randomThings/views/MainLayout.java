package me.infinity.randomThings.views;

import me.infinity.randomThings.views.users.UsersView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("")
@PageTitle("Home")
@CssImport("./styles/main.css")
public class MainLayout extends VerticalLayout {
    public MainLayout() {
        final H1 title = new H1("Click on what you want to see.");
        title.addClassName("title");

        Button userProfiles = new Button("User Profiles");
        userProfiles.setIcon(VaadinIcon.USER.create());
        userProfiles.addClassName("user-profiles-button");
        userProfiles.addClickListener(
                evt -> UI.getCurrent().navigate(UsersView.class)
        );

        add(title, userProfiles);
    }
}
