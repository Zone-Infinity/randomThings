package me.infinity.randomThings.views.users;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.DomEventListener;
import com.vaadin.flow.router.Route;
import me.infinity.randomThings.backend.service.UserService;
import me.infinity.randomThings.component.UserCard;

@Route("users")
@CssImport("./styles/user.css")
public class UsersView extends VerticalLayout {

    public UsersView(UserService userService) {
        final H1 title = new H1("Click for random user profiles.");
        title.addClassName("title");
        add(title);

        getElement().getStyle().set("background-color", "rgb(255, 170, 155)");

        DomEventListener event = e -> {
            final UserCard userCard = new UserCard(userService.getRandomUser());
            add(userCard);
            UI.getCurrent().getPage().executeJs("var element = document.getElementById('" + userCard.getId().get() + "');\n" +
                    "element.scrollIntoView({behavior: 'smooth'});");
        };

        UI.getCurrent().getElement().addEventListener("click", event);
    }
}
