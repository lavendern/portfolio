package org.lneagle.audiomancer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lneagle.audiomancer.utils.FileUtil;

import de.umass.lastfm.Album;
import de.umass.lastfm.Artist;
import de.umass.lastfm.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Setup {
	
//	ComboBox moodSelect;
//	Button newMood;
//	StackPane mood;

//	Button addMusic;
//	Scene moodSc;
//	
//	Scene musicAdd;
//	
//	Stage primStage;
	
	public Setup(Stage primarystage) {

	}
	
	public static void startSetup(Stage primarystage) {
		ObservableList<String> moods = FXCollections.observableArrayList();
		ObservableList<String> music = FXCollections.observableArrayList();
		List<String> artists = new ArrayList<String>();
		
		StackPane mood = new StackPane();
		
		Text moodinfo = new Text("Moods");
		moodinfo.setTranslateY(-255);
		moodinfo.setTranslateX(200);
		
		
		Button newMood = new Button("+");
		newMood.setTranslateY(-250);
		newMood.setTranslateX(200);
		
		Button removeMood = new Button("-");
		removeMood.setTranslateY(-250);
		removeMood.setTranslateX(250);
		
		Button addMusic = new Button("+");
		addMusic.setTranslateY(-120);
		addMusic.setTranslateX(200);
		
		Button removeMusic = new Button("-");
		removeMusic.setTranslateY(-120);
		removeMusic.setTranslateX(250);
		
		Button done = new Button("Done");
		
		ComboBox<String> moodSelect = new ComboBox<String>(moods);
		moodSelect.setEditable(false);
		moodSelect.setTranslateX(-250);
		moodSelect.setTranslateY(-250);
		
		Text moodi = new Text("Moods");
		moodi.setTranslateY(-270);
		moodi.setTranslateX(-250);
		
		Text musici = new Text("Music");
		musici.setTranslateX(-250);
		musici.setTranslateY(-140);
		
		ComboBox<String> musicSelect = new ComboBox<String>(music);
		musicSelect.setEditable(false);
		musicSelect.setTranslateX(-250);
		musicSelect.setTranslateY(-120);
		
		done.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				List<String> moodToText =  moodSelect.getItems();
				List<String> musicToText = musicSelect.getItems();
				FileUtil.writeToTextFile(moodToText, "C:\\audiomancer\\moods.txt");
				FileUtil.writeToTextFile(musicToText, "C:\\audiomancer\\music.txt");
				FileUtil.writeToTextFile(artists, "C:\\audiomancer\\artists.txt");
				DefaultScene.startDefaultScene(primarystage);
			}
		});
		
		newMood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage addMood = new Stage();
				
				addMood.initModality(Modality.APPLICATION_MODAL);
				addMood.initOwner(primarystage);
				
				StackPane moodpane = new StackPane();
				
				
				TextField moodField = new TextField();
				moodField.setTranslateY(-40);

				Button confirmField = new Button("Ok");
				confirmField.setTranslateX(-50);
				
				Button cancelField = new Button("Cancel");
				cancelField.setTranslateX(50);
				
				confirmField.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						moods.add(moodField.getText());
						addMood.close();
						primarystage.show();
					}
				});
				
				cancelField.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						addMood.close();
						primarystage.show();
					}
				});
				
				moodpane.getChildren().add(moodField);
				moodpane.getChildren().add(confirmField);
				moodpane.getChildren().add(cancelField);
				
				Scene moodAdd = new Scene(moodpane, 240, 180);
				
				addMood.setScene(moodAdd);
				addMood.show();
			}
		});
		
		addMusic.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				Stage musicAdd = new Stage();
				
				musicAdd.initModality(Modality.APPLICATION_MODAL);
				musicAdd.initOwner(primarystage);
				
				StackPane pane = new StackPane();
				
				TextField field = new TextField();
				field.setTranslateY(-40);

				
				Button confirmField = new Button("Ok");
				confirmField.setTranslateX(-75);
				
				Button cancelField = new Button("Cancel");
				//cancelField.setTranslateX(25);
				
				Button searchArtist = new Button("Search Artist");
				searchArtist.setTranslateX(-75);
				searchArtist.setTranslateY(50);
				
				Button searchSong = new Button("Search Album");
				//searchSong.setTranslateX(-75);
				searchSong.setTranslateY(50);
				
				Button searchAlbum = new Button("Search Album");
				searchAlbum.setTranslateX(-75);
				searchSong.setTranslateY(100);
				
				Button topArtist = new Button("Top Artist");
				topArtist.setTranslateX(-125);
				topArtist.setTranslateY(50);
				
				Button topSong = new Button("Top Album");
				//topSong.setTranslateX(-125);
				topSong.setTranslateY(50);
				
				Button topAlbum = new Button("Top Album");
				topAlbum.setTranslateX(-125);
				topAlbum.setTranslateY(100);
			 

				searchSong.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						String song = field.getText();
						if(song != null) {
							System.out.println(song);
							Collection<Album> searchresults = Album.search(song, Main.key);
							List<Album> results = new ArrayList<Album>(searchresults);
							
							Album res1 = results.get(0);
							Album res2 = results.get(1);
							Album res3 = results.get(2);
							
							Button r1 = new Button(res1.getArtist() + " - " + res1.getName());
							r1.setTranslateY(-50);
							Button r2 = new Button(res2.getArtist() + " - " + res2.getName());
							Button r3 = new Button(res2.getArtist() + " - " + res3.getName());
							r3.setTranslateY(50);
							
							Stage result = new Stage();
							StackPane rs = new StackPane();
							
							rs.getChildren().add(r1);
							rs.getChildren().add(r2);
							rs.getChildren().add(r3);
							
							result.initModality(Modality.APPLICATION_MODAL);
							result.initOwner(musicAdd);
							
							Scene res = new Scene(rs, 480, 240);
							
							result.setScene(res);
							result.show();
							
							r1.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									music.add(res1.getName());
									artists.add(res1.getArtist());
									result.close();
									musicAdd.close();
								}
							});
							
							r2.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									music.add(res2.getName());
									artists.add(res2.getArtist());
									result.close();
									musicAdd.close();
								}
							});
							
							r3.setOnAction(new EventHandler<ActionEvent>() {
								public void handle(ActionEvent event) {
									music.add(res3.getName());
									artists.add(res3.getArtist());
									result.close();
									musicAdd.close();
								}
							});
							
						}
					}
				});
				
				topSong.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						
					}
				});
				
				confirmField.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(field.getText() != null) {
						music.add(field.getText());
						musicAdd.close();
						primarystage.show();
						}
					}
				});
				
				cancelField.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						musicAdd.close();
						primarystage.show();
					}
				});
				
				pane.getChildren().add(field);
				//pane.getChildren().add(confirmField);
				pane.getChildren().add(cancelField);
				//pane.getChildren().add(searchAlbum);
				pane.getChildren().add(searchSong);
//				pane.getChildren().add(searchArtist);
//				pane.getChildren().add(topAlbum);
//				pane.getChildren().add(topSong);
//				pane.getChildren().add(topArtist);
				
				
				Scene moodAdd = new Scene(pane, 480, 240);
				
				musicAdd.setScene(moodAdd);
				musicAdd.show();
			}
		});
		
		removeMood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(moodSelect.getItems().size() > 0) {
				int i = moodSelect.getSelectionModel().getSelectedIndex();
				moodSelect.getItems().remove(i);
				if(musicSelect.getItems().size() >= i)
				{
					musicSelect.getItems().remove(i);
				}
				}
			}
		});
		
		removeMusic.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(musicSelect.getItems().size() > 0) {
				int i = musicSelect.getSelectionModel().getSelectedIndex();
				musicSelect.getItems().remove(i);
				}
			}
		});
		
		mood.getChildren().add(newMood);
		mood.getChildren().add(moodSelect);
		mood.getChildren().add(addMusic);
		mood.getChildren().add(musicSelect);
		mood.getChildren().add(removeMusic);
		mood.getChildren().add(removeMood);
		mood.getChildren().add(done);
		mood.getChildren().add(musici);
		mood.getChildren().add(moodi);
		
	
		
		Scene moodSc = new Scene(mood, 800, 600);
		
		primarystage.setScene(moodSc);
		primarystage.show();
	}

	public static void preSetup(Stage primaryStage) {
		StackPane sb = new StackPane();
		 Text info = new Text("You will now need to setup the application by \n selecting an album \n for each mood.");
		info.setTranslateY(-10);
		
		Button setupStart = new Button("Setup");
		setupStart.setTranslateY(20);
		
		setupStart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Setup.startSetup(primaryStage);
			}
			
		});
		
		
		 Scene setupBegin = new Scene(sb, 360, 240);
		
		
		sb.getChildren().add(info);
		sb.getChildren().add(setupStart);
		
		primaryStage.setScene(setupBegin);
		primaryStage.show();
		
	}
}
