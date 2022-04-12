package org.lneagle.audiomancer;

import java.awt.Desktop;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DefaultScene {

	public static void startDefaultScene(Stage primarystage)
	{
		StackPane pane = new StackPane();
		ObservableList<String> moods = FXCollections.observableArrayList(FileUtil.readTextFile("C:\\audiomancer\\moods.txt"));
		ComboBox<String> moodList = new ComboBox<String>(moods);
		Button generateRecommendation = new Button("Go");
		moodList.setTranslateY(-40);
		Text ind = new Text("Moods");
		ind.setTranslateY(-60);
		
		Button setup = new Button("Setup");
		setup.setTranslateY(-125);
		setup.setTranslateX(150);
		
		
		setup.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				FileUtil.removeTextFile("C:\\audiomancer\\music.txt");
				FileUtil.removeTextFile("C:\\audiomancer\\moods.txt");
				
				Setup.preSetup(primarystage);
			}
		});
		
		generateRecommendation.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Stage recommendations = new Stage();
				
				recommendations.initModality(Modality.APPLICATION_MODAL);
				recommendations.initOwner(primarystage);
				
				StackPane rpane = new StackPane();
				
				int i = moodList.getSelectionModel().getSelectedIndex();
				
				String album = FileUtil.readTextFile("C:\\audiomancer\\music.txt").get(i);
				String artist = FileUtil.readTextFile("C:\\audiomancer\\artists.txt").get(i);
				
				List<Album> results = new ArrayList<Album>(Album.search(album +" "+artist, Main.key));
				Album orig = results.get(0);
				Collection<Track> origtracks = Album.getInfo(artist, album, Main.key).getTracks();
				List<Track> tracks = new ArrayList<Track>(origtracks);
				
				Track origtrack = tracks.get(0);
				
				// Getting similar tracks
				Collection<Track> s1 = Track.getSimilar(artist, tracks.get(0).getName(), Main.key, 6);
				if(s1.size() == 0) {
					List<Track> toptracks = new ArrayList<Track>(Artist.getTopTracks(artist, Main.key));
					s1 = Track.getSimilar(artist, toptracks.get(0).getName(), Main.key);
					System.out.print(s1);
				}
				List<Track> simtrack = new ArrayList<Track>(s1);
				
				System.out.print(simtrack.get(2).getName());
				System.out.print(simtrack.get(3).getName());
				System.out.print(simtrack.get(4).getName());

				Text info1 = new Text("Track 1:");
				info1.setTranslateY(-250);
				Text info2 = new Text("Track 2:");
				info2.setTranslateY(-125);
				Text info3 = new Text("Track 3:");
				info3.setTranslateY(125);
				
				Hyperlink track1 = new Hyperlink(simtrack.get(2).getArtist() + " - " + simtrack.get(2).getName());
				track1.setTranslateY(-240);
				Hyperlink track2 = new Hyperlink(simtrack.get(3).getArtist() + " - " + simtrack.get(3).getName());
				track2.setTranslateY(-115);
				Hyperlink track3 = new Hyperlink(simtrack.get(4).getArtist() + " - " + simtrack.get(4).getName());
				track3.setTranslateY(135);
				
				Button ok = new Button("Ok");
				ok.setTranslateY(250);
				
				ok.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						recommendations.close();
						primarystage.show();
					}
				});
				
				track1.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						try {
							Desktop.getDesktop().browse(FileUtil.createURI(simtrack.get(2).getUrl()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				track2.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						try {
							Desktop.getDesktop().browse(FileUtil.createURI(simtrack.get(3).getUrl()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				track3.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						try {
							Desktop.getDesktop().browse(FileUtil.createURI(simtrack.get(4).getUrl()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				
				rpane.getChildren().add(track1);
				rpane.getChildren().add(track2);
				rpane.getChildren().add(track3);
				rpane.getChildren().add(info1);
				rpane.getChildren().add(info2);
				rpane.getChildren().add(info3);
				rpane.getChildren().add(ok);
				
				Scene rec = new Scene(rpane, 800, 600);
				
				recommendations.setScene(rec);
				recommendations.show();

				
			}
		});
		
		pane.getChildren().add(moodList);
		pane.getChildren().add(generateRecommendation);
		pane.getChildren().add(setup);
		pane.getChildren().add(ind);
		
		Scene defaultScene = new Scene(pane, 400, 300);
		
		primarystage.setScene(defaultScene);
		primarystage.show();
	}
}
