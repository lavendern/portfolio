package org.lneagle.audiomancer;

import de.umass.lastfm.Authenticator;
import de.umass.lastfm.Caller;
import de.umass.lastfm.PaginatedResult;
import de.umass.lastfm.Session;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.lneagle.audiomancer.utils.FileUtil;
import org.lneagle.audiomancer.utils.SettingTemplate;

public class Main extends Application {

	static String key = "REDACTED";
	static String secret = "REDACTED";
	String user;
	static String token = Authenticator.getToken(key);
	Session session;
	
	

	
	public static void main(String[] args) {
		Caller.getInstance().setUserAgent("audiomancer");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		
		if(FileUtil.fileExists("C:\\audiomancer\\sessionkey.txt") == false )
		{
		
			
			
		
		Hyperlink link = new Hyperlink("Please authorize the application by clicking here then clicking the authorize button.");
		Button btn = new Button();
		btn.setText("Authorized");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				
				session = Authenticator.getSession(token, key, secret);
				if(session != null)
				{
				System.out.println("Sessionkey saved.");
				FileUtil.writeToTextFile(session.getKey(), "C:\\audiomancer\\sessionkey.txt");
				Setup.preSetup(primaryStage);
				} else {
					System.out.println("Session null.");
				}
			}
		});
		link.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(FileUtil.createURI("http://www.last.fm/api/auth/?api_key="+key+"&token="+token));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		StackPane auth = new StackPane();
		auth.getChildren().add(btn);
		auth.getChildren().add(link);
		link.setTranslateY(20);
		Scene authsc = new Scene(auth, 640, 480);
		
		primaryStage.setTitle("Audiomancer");
		
		
		
		
		StackPane login = new StackPane();
		TextField username = new TextField();
		username.setTranslateY(40);
		Button loginbutton = new Button("Login");
		
		loginbutton.setOnAction(new EventHandler<ActionEvent> () {

			public void handle(ActionEvent event) {
				if (loginbutton.getText() != null)
				{
					user = loginbutton.getText();
					FileUtil.writeToTextFile(user, "C:\\audiomancer\\user.txt");

					
					
					primaryStage.setScene(authsc);
					primaryStage.show();
				}
			}
			
		});
		
		login.getChildren().add(username);
		login.getChildren().add(loginbutton);
		
		Scene loginsc = new Scene(login, 240, 180);
		
		primaryStage.setScene(loginsc);
		primaryStage.show();
		
		
		
		} else {
			session = Session.createSession(key, secret, FileUtil.readTextFile("C:\\audiomancer\\sessionkey.txt").get(0));
			user = FileUtil.readTextFile("C:\\audiomancer\\user.txt").get(0);

			if(FileUtil.fileExists("C:\\audiomancer\\moods.txt") == false && FileUtil.fileExists("C:\\audiomancer\\music.txt") == false)
			{
				//SettingTemplate st = new SettingTemplate
				//FileUtil.writeToTextFile("test = false", "C:\\audiomancer\\settings.txt");
				
				// Start going through setup scene
				 Setup.preSetup(primaryStage);
				
			} else {
				// Continue to default scene 
				DefaultScene.startDefaultScene(primaryStage);
				
				/* TODO: remember that since you cant make playlists with the api (afaik) the default recommendation 
				mode will be based off of selecting a mood and giving the user a certain album, song, or tag they selected
				for that mood during setup */
			}
			
			
		}
	}
	

}

//Authenticator.getSession(token, key, secret);
