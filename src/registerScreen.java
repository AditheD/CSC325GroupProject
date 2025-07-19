package src;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import resources.FirebaseAuthService;
import src.RegisterUser; // Assuming this is your user registration handler
import src.DietAppMainScreen; // Assuming this is your main app screen

public class RegisterScreen {
    private final Stage stage;
    private final FirebaseAuthService authService = new FirebaseAuthService();

    public RegisterScreen(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        BorderPane root = new BorderPane();
        Label title = new Label("Registration Screen");
        title.setId("titleLabel");

        VBox regInfo = new VBox();
        regInfo.setId("regInfo");

        TextField username = new TextField();
        username.setPromptText("Enter Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Enter Password");

        TextField email = new TextField();
        email.setPromptText("Enter Email");

        TextField phone = new TextField();
        phone.setPromptText("Enter Phone Number");

        Button submit = new Button("Submit");
        submit.setId("submitButton");
        submit.setOnAction(e -> {
            String emailString = email.getText();
            String phoneString = phone.getText();
            String usernameString = username.getText();
            String passwordString = password.getText();

            RegisterUser registerUser = new RegisterUser();
            registerUser.register(emailString, phoneString, passwordString, usernameString);

            DietAppMainScreen dietAppMainScreen = new DietAppMainScreen();
            dietAppMainScreen.show();
        });

        regInfo.getChildren().addAll(username, password, email, phone, submit);

        root.setTop(title);
        root.setCenter(regInfo);

        Scene scene = new Scene(root, 700, 600);
        stage.setScene(scene);
        stage.setTitle("Registration Screen");
        stage.show();
    }
}