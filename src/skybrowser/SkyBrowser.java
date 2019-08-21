
package skybrowser;
import java.awt.Desktop;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.web.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.*;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
import javafx.beans.value.*;
import static javafx.concurrent.Worker.State;
import javafx.print.*;
//import javafx.scene.web.WebHistory.Entry;
//import org.w3c.dom.Document;
import javafx.scene.image.*;
import javafx.concurrent.*;
import org.apache.commons.io.FileUtils;
import java.util.*;
import javafx.beans.binding.Bindings;
import javafx.collections.*;
import javafx.util.Duration;
import javafx.animation.*;

/**
 *
 * @author SeumX Plus
 */
public class SkyBrowser extends Application {
    
    private Label nmm; private Properties pro; private URL fl1; private File file; private FileInputStream inf;
    private ObjectInputStream objll; private FileOutputStream ouf; private ObjectOutputStream obot;
    
    @Override
    @SuppressWarnings("ConvertToTryWithResources")
    public void start(Stage Stage) throws Exception {
        Stage.initStyle(StageStyle.DECORATED);Stage.setOpacity(1);Stage.setResizable(true);
        Image icon=new Image(new FileInputStream("icon.png"));Stage.getIcons().add(icon);
        HostServices service=getHostServices(); Desktop dsktp=Desktop.getDesktop();
        
        BackgroundFill bf=new BackgroundFill(Color.WHITE,new CornerRadii(0),new Insets(0,0,0,0));Background bg=new Background(bf);
        BackgroundFill bf1=new BackgroundFill(Color.LIGHTGREY,new CornerRadii(0),new Insets(0,0,0,0));Background bg1=new Background(bf1);
        BackgroundFill bf2=new BackgroundFill(Color.DARKBLUE,new CornerRadii(0),new Insets(0,0,0,0));Background bg2=new Background(bf2);
        BackgroundFill bf3=new BackgroundFill(Color.ALICEBLUE,new CornerRadii(0),new Insets(0,0,0,0));Background bg3=new Background(bf3);
        BackgroundFill bf4=new BackgroundFill(Color.DARKGREY,new CornerRadii(0),new Insets(0,0,0,0)); Background bg4=new Background(bf4);
        BackgroundFill bf5=new BackgroundFill(Color.BLACK,new CornerRadii(0),new Insets(0,0,0,0)); Background bg5=new Background(bf5);
        
        //retreving data from file
        FileInputStream in=new FileInputStream("theme.bat");
        ObjectInputStream obin=new ObjectInputStream(in);
        pro=new Properties(); pro=(Properties) obin.readObject();
        
        Text br=new Text("SeumX Browser");br.setStyle("-fx-font:bold 31.7px 'Cambria'");br.setFill(Color.ALICEBLUE);
        Button gg=new Button("Google");gg.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:bold 17px 'Cambria'");
        
        WebView web=new WebView();web.setPrefWidth(1700);web.setPrefHeight(900);web.setFontSmoothingType(FontSmoothingType.GRAY);
        WebEngine gt=web.getEngine(); WebHistory his=web.getEngine().getHistory();web.getEngine().setJavaScriptEnabled(true);
        
        Button home=new Button("Home");home.setStyle("-fx-background-color:purple;-fx-text-fill:white;-fx-font:bold 17px 'Cambria'");
        Button back=new Button("<");back.setStyle("-fx-background-color:aliceblue;-fx-text-fill:black;-fx-font:bold 18px 'Cambria'");
        Button forwd=new Button(">");forwd.setStyle("-fx-background-color:aliceblue;-fx-text-fill:black;-fx-font:bold 18px 'Cambria'");
        
        Button go=new Button("Go");go.setStyle("-fx-background-color:aliceblue;-fx-text-fill:black;-fx-font:bold 15px 'Cambria'");
        Button hist=new Button("History");hist.setStyle("-fx-background-color:slateblue;-fx-text-fill:white;-fx-font:normal 17px 'Cambria'");
        TextField entry=new TextField("http://");HBox.setHgrow(entry, Priority.ALWAYS);entry.setPrefWidth(430);Text space=new Text("             ");
        entry.setStyle("-fx-font:normal 15px 'Cambria'");
        
        MenuItem re=new MenuItem("Reload"); MenuItem down=new MenuItem("Save Page"); MenuItem shr=new MenuItem("Share");
        MenuItem tb=new MenuItem("New Window"); MenuItem hst=new MenuItem("History"); MenuItem dwn=new MenuItem("Downloads");
        MenuItem bkm=new MenuItem("Bookmarks"); MenuItem set=new MenuItem("Settings"); MenuItem hlp=new MenuItem("Help");
        MenuItem cp=new MenuItem("Copy");MenuItem pr=new MenuItem("Print");MenuItem open=new MenuItem("Open");MenuItem abt=new MenuItem("About");
        MenuItem stp=new MenuItem("Stop"); MenuItem dsk=new MenuItem("Open With Desktop"); stp.setDisable(true); dsk.setDisable(true);
        MenuItem adb=new MenuItem("Add to bookmarks"); adb.setDisable(true);
        
        bkm.setDisable(false); shr.setDisable(true); dwn.setDisable(false);re.setDisable(true);pr.setDisable(true);down.setDisable(true);
        
        MenuButton opt=new MenuButton("...",null,open,tb,re,stp,dsk,down,adb,shr,hst,dwn,bkm,pr,set,hlp,abt);
        opt.setStyle("-fx-background-color:aliceblue;-fx-text-fill:black;-fx-font:bold 15px 'Cambria'");
        Text sp=new Text("                                                                                                              ");
        ContextMenu conm=new ContextMenu();conm.getItems().addAll(tb,re,cp,down,shr,pr);
        
        Button mail=new Button("Gmail");mail.setStyle("-fx-background-color:darkgreen;-fx-text-fill:aliceblue;-fx-font:bold 17px 'Cambria'");
        Button utub=new Button("YouTube");utub.setStyle("-fx-background-color:darkred;-fx-text-fill:aliceblue;-fx-font:bold 17px 'Cambria'");
        
        Button downloads=new Button("Downloads");downloads.setStyle("-fx-font:normal 15px 'Cambria';-fx-background-color:darkslategrey;-fx-text-fill:white");
        Button history=new Button("History");history.setStyle("-fx-font:normal 15px 'Cambria';-fx-background-color:darkslategrey;-fx-text-fill:white");
        Button saved=new Button("Saved");saved.setStyle("-fx-font:normal 15px 'Cambria';-fx-background-color:darkslategrey;-fx-text-fill:white");
        
        GridPane st=new GridPane();st.setPadding(new Insets(4,4,4,4));st.setVgap(5);st.setHgap(5);st.setAlignment(Pos.TOP_LEFT);
        st.add(home,0,0);st.add(back,1,0);st.add(forwd,2,0);st.add(entry,3,0);st.add(go,4,0);st.add(opt,5,0);
        st.add(gg,7,0);st.add(mail,8,0);st.add(utub,9,0);
        
        Text sky=new Text("SeumX Browser");sky.setStyle("-fx-font:Bold 50px 'Cambria'");sky.setFill(Color.NAVY);
        Text fst=new Text("Fast,Effecient and Lite");fst.setStyle("-fx-font:Bold 40px 'Cambria'");fst.setFill(Color.OLIVEDRAB);
        Button music=new Button("M");music.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:purple;-fx-text-fill:aliceblue");
        Button movie=new Button("M");movie.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:darkslateblue;-fx-text-fill:aliceblue");
        Button news=new Button("N");news.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:darkred;-fx-text-fill:aliceblue");
        Button book=new Button("B");book.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:black;-fx-text-fill:aliceblue");
        
        music.setOnMouseMoved(e->music.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:blueviolet;-fx-text-fill:aliceblue"));
        movie.setOnMouseMoved(e->movie.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:blueviolet;-fx-text-fill:aliceblue"));
        news.setOnMouseMoved(e->news.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:blueviolet;-fx-text-fill:aliceblue"));
        book.setOnMouseMoved(e->book.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:blueviolet;-fx-text-fill:aliceblue"));
        
        music.setOnMouseExited(e->music.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:purple;-fx-text-fill:aliceblue"));
        movie.setOnMouseExited(e->movie.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:darkslateblue;-fx-text-fill:aliceblue"));
        news.setOnMouseExited(e->news.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:darkred;-fx-text-fill:aliceblue"));
        book.setOnMouseExited(e->book.setStyle("-fx-font:Bold 40px 'Cambria';-fx-background-color:black;-fx-text-fill:aliceblue"));
        
        Label ms=new Label("    Music");ms.setStyle("-fx-font:bold 20px 'Cambria'");  Label mv=new Label("    Movies");mv.setStyle("-fx-font:bold 20px 'Cambria'");
        Label nw=new Label("    News");nw.setStyle("-fx-font:bold 20px 'Cambria'");  Label bk=new Label("    Books");bk.setStyle("-fx-font:bold 20px 'Cambria'");
        
        music.setPrefSize(100,50);movie.setPrefSize(100,50);news.setPrefSize(100,50);book.setPrefSize(100,50);downloads.setPrefSize(100,30);
        history.setPrefSize(90,30);saved.setPrefSize(90,30);
        
        GridPane itm=new GridPane();itm.setVgap(8);itm.setHgap(8);itm.setPadding(new Insets(10,10,10,10));itm.setAlignment(Pos.CENTER);
        itm.add(music,0,0);itm.add(movie,1,0);itm.add(news,2,0);itm.add(book,3,0);itm.add(ms,0,1);itm.add(mv,1,1);itm.add(nw,2,1);itm.add(bk,3,1);
        //itm.setBorder(new Border(new BorderStroke(Color.DARKRED,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        
        final GridPane log=new GridPane();log.setVgap(4);log.setHgap(5);log.setPadding(new Insets(3,3,3,3));log.setAlignment(Pos.CENTER);
        log.setOpacity(1);log.add(sky,0,0);log.add(fst,0,2);log.add(itm,0,3);Slider load=new Slider();load.setPrefWidth(200);
        load.setMin(0);load.setMax(1);
        
        TabPane tabp=new TabPane();Tab tab=new Tab("New Tab");tab.setContent(log);tabp.getTabs().add(tab);ProgressIndicator ind=new ProgressBar();
        /*tabp.setBackground(bg4);*/ind.setProgress(0.0);ind.setPrefWidth(47);ind.setPrefHeight(23);
        
        GridPane hg=new GridPane();hg.setPadding(new Insets(3,3,3,3));hg.setVgap(1);hg.setHgap(27);hg.setAlignment(Pos.CENTER);
        hg.setOpacity(1);hg.add(load,0,0);hg.add(br,1,0);hg.add(ind,2,0);
        
        BorderPane webap=new BorderPane();webap.setTop(st);webap.setBottom(hg);webap.setCenter(tabp);
        
        //downloads
        Label doo=new Label("Downloads"); doo.setStyle("-fx-font:bold 19px 'Cambria';-fx-text-fill:white");
        VBox uio=new VBox(); uio.setPadding(new Insets(2)); uio.setAlignment(Pos.TOP_LEFT);
        uio.setStyle("-fx-background-color: blueviolet; -fx-border-color:black"); uio.getChildren().add(doo); uio.setPrefWidth(323);
        //download dialog
        Label dst=new Label("Starting download....."); dst.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
        HBox hbb=new HBox(); hbb.setPadding(new Insets(3)); hbb.setAlignment(Pos.CENTER); hbb.getChildren().addAll(dst);
        Stage dwh=new Stage(); Scene hju=new Scene(hbb); dwh.setWidth(300); dwh.setHeight(150); dwh.initOwner(Stage);
        dwh.setOpacity(0.7); 
        //transmition
        FadeTransition fdd=new FadeTransition(Duration.millis(2000));
        fdd.setNode(hbb); fdd.setFromValue(0.7); fdd.setToValue(1); fdd.setAutoReverse(false); fdd.setCycleCount(1);
        fdd.setOnFinished(evv->{
            dwh.close();
        });
        
        Scene sn=new Scene(webap);Stage.setHeight(577);Stage.setWidth(988);Stage.setTitle("SeumX Browser");Stage.setScene(sn);
        //displaying start up pane
        Image imm=new Image(new FileInputStream("icon.png"));
        ImageView vww=new ImageView(imm); vww.setFitWidth(177); vww.setFitHeight(177);
        Label ssmm=new Label("SeumX Browser"); ssmm.setStyle("-fx-font:bold 24px 'Cambria'; -fx-text-fill:azure;");
        ProgressIndicator pind=new ProgressIndicator(); pind.setStyle("-fx-progress-color:lightgrey");
        pind.setPrefWidth(70); pind.setPrefHeight(70);
        GridPane pnm=new GridPane(); pnm.setPadding(new Insets(2,2,2,2)); pnm.setVgap(9); pnm.setHgap(9); pnm.setAlignment(Pos.CENTER);
        pnm.add(vww,0,0); pnm.add(pind,0,1); pnm.add(ssmm,0,2);
        Scene df=new Scene(pnm); Stage stg=new Stage(); stg.initStyle(StageStyle.UNDECORATED); stg.setScene(df);
        stg.setWidth(497); stg.setHeight(301); stg.getIcons().add(icon); 
        
        //applying theme
        if(pro.get("theme").equals("normal")){
            st.setBackground(bg1); webap.setBackground(bg); hg.setBackground(bg2); pnm.setStyle("-fx-background-color:navy"); 
        }
        if(pro.get("transparent").equals("yes")){
            Stage.setOpacity(0.9); stg.setOpacity(0.9);
        }
        if(pro.get("theme").equals("dark")){
            st.setBackground(bg5); webap.setBackground(bg4); hg.setBackground(bg5); pnm.setStyle("-fx-background-color:black");
        }
        if(pro.get("transparent").equals("no")){
            Stage.setOpacity(1); stg.setOpacity(1);
        }
        
        stg.show();
        FadeTransition hyr=new FadeTransition(Duration.millis(4000)); hyr.setNode(vww); hyr.setFromValue(0.3); hyr.setToValue(1);
        hyr.setAutoReverse(false); hyr.setCycleCount(2);hyr.play();
        hyr.setOnFinished(ytre->{
            stg.close(); Stage.show();
        });
        
        File page=new File("help_doc.html");
        URL url=page.toURI().toURL();
        
        Task<Void> task=new Task<Void>(){
            @Override
            protected Void call() throws Exception {
                
                return null;
            }
        };
        
        gt.getLoadWorker().stateProperty().addListener((ObservableValue<? extends State>ov, State oldS, State newS) -> {
            if(newS.equals(State.SUCCEEDED)){down.setDisable(false);re.setDisable(false);pr.setDisable(false); stp.setDisable(true);
                tab.setText(gt.getTitle());ind.setProgress(1); adb.setDisable(false);
                //storing history
                try {
                    //reading history file 
                    FileInputStream ino=new FileInputStream("history.dll");
                    ObjectInputStream objin=new ObjectInputStream(ino);
                    pro=new Properties(); pro=(Properties) objin.readObject();
                    
                    //writing data to the file
                    pro.put(gt.getTitle(),entry.getText());
                    FileOutputStream outt=new FileOutputStream("history.dll");
                    ObjectOutputStream objout=new ObjectOutputStream(outt);
                    objout.writeObject(pro); objout.flush(); objout.close(); outt.close(); 
                    
                } catch (FileNotFoundException ex){
                    System.out.println("Error fetching file......");
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(newS.equals(State.RUNNING)){ stp.setDisable(false); dsk.setDisable(false); adb.setDisable(true);
                entry.setText(gt.getLocation());ind.setProgress(-1);re.setDisable(true);down.setDisable(true);pr.setDisable(true);
                load.valueProperty().bind(gt.getLoadWorker().progressProperty());
            if(gt.getLocation().endsWith(".mp4")){
                service.showDocument(gt.getLocation());
                /*
                try{
                    FileChooser chose=new FileChooser();chose.getExtensionFilters().add(new FileChooser.ExtensionFilter("MP4 VIDEO",".mp4"));
                    fl1=new URL(entry.getText()); chose.setInitialFileName(fl1.getFile()); file =chose.showSaveDialog(Stage);
                    dwh.show(); fdd.play(); 
                    nmm=new Label("downloading_"+fl1.getFile()); nmm.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
                    uio.getChildren().add(nmm);
                    
                    if(file!=null){
                     //download file
                    FileUtils.copyURLToFile(fl1, file);
                    nmm.setText("Completed_"+fl1.getFile());
                    
                    //recording download
                    inf=new FileInputStream("download.dll");
                    objll=new ObjectInputStream(inf);
                    pro=new Properties(); pro=(Properties) objll.readObject();
                    pro.put(file.getName(), file.getAbsolutePath());
                    
                    //writing download to database
                    ouf=new FileOutputStream("download.dll");
                    obot=new ObjectOutputStream(ouf);
                    obot.writeObject(pro); obot.flush(); obot.close(); ouf.close();
                    }
                    
                } catch (MalformedURLException | ClassNotFoundException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Input Output error.....");
                }*/
                
                }
            if(gt.getLocation().endsWith(".avi")){
                service.showDocument(gt.getLocation());
                /*
                try{
                    FileChooser chose=new FileChooser();chose.getExtensionFilters().add(new FileChooser.ExtensionFilter("AVI VIDEO",".avi"));
                    fl1=new URL(entry.getText()); chose.setInitialFileName(fl1.getFile()); file =chose.showSaveDialog(Stage);
                    dwh.show(); fdd.play(); 
                    nmm=new Label("downloading_"+fl1.getFile()); nmm.setStyle("-fx-font:normal 15px 'Cambria'; -fx-text-fill:azure");
                    uio.getChildren().add(nmm); 
                    
                    if(file!=null){
                     //download file
                    FileUtils.copyURLToFile(fl1, file);
                    nmm.setText("Completed_"+fl1.getFile());  
                    
                    //recording download
                    inf=new FileInputStream("download.dll");
                    objll=new ObjectInputStream(inf);
                    pro=new Properties(); pro=(Properties) objll.readObject();
                    pro.put(file.getName(), file.getAbsolutePath());
                    
                    //writing download to database
                    ouf=new FileOutputStream("download.dll");
                    obot=new ObjectOutputStream(ouf);
                    obot.writeObject(pro); obot.flush(); obot.close(); ouf.close();
                    }
                    
                } catch (MalformedURLException | ClassNotFoundException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    System.out.println("Input Output error.....");
                }*/
            }
            if(gt.getLocation().endsWith(".mp3")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".audio")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".pdf")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".doc")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".xls")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".exe")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".msi")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".zip")){service.showDocument(gt.getLocation()); }
            if(gt.getLocation().endsWith(".rar")){service.showDocument(gt.getLocation()); }     }
            
        });
        
        gg.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
               log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);gt.load("http://www.google.com");
               /*File ddd=new File("D:/Syrus/google.html"); try {
                   URL ggg=new URL("http://www.google.com"); FileUtils.copyURLToFile(ggg, ddd);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            }
        }));
        
        home.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(sky,0,0);log.add(fst,0,2);log.add(itm,0,3);tab.setText("New Tab");entry.setText("http://");
                ind.setProgress(0.0); dsk.setDisable(true); re.setDisable(true); down.setDisable(true); pr.setDisable(true); adb.setDisable(true); stp.setDisable(true);
            }
        }));
        back.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);his.go(-1);
            }
        }));
        forwd.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);his.go(1);
            }
        }));
        go.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);gt.load(entry.getText());
            }
        }));
        mail.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);
                gt.load("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1");
            }
        }));
        utub.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);gt.load("http://www.youtube.com");
            }
        }));
        entry.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0);gt.load(entry.getText());
            }
        }));
        tb.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                /*tabp.getTabs().clear();tabp.getTabs().add(tab);
               if(tabp.getTabs().size()>=1){
                   WebView web2=new WebView(); WebEngine gt2=web2.getEngine(); GridPane pn=new GridPane();pn.setPadding(new Insets(5,5,5,5));
                   pn.setVgap(7);pn.setHgap(7);pn.setAlignment(Pos.CENTER); pn.add(web2,0,0); gt2.load("http://www.google.com");
                   Tab tab2=new Tab();tab2.setText("New Tab");tab2.setContent(pn); tabp.getTabs().add(tab2); web2.setPrefWidth(1000);
               }*/
                
                
                try {
                File nw=new File("nwin.jar"); dsktp.open(nw); 
                } catch (IOException ex) {
                    System.out.println("could not find the specified file................");
                }
                
                /*Stage kol=new Stage(); kol.setScene(sn); kol.setWidth(988); kol.setHeight(577); kol.setTitle("SeumXBrowser");
                kol.getIcons().add(icon); kol.show();*/
            }
        }));
        re.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                tabp.getTabs().clear();tabp.getTabs().add(tab);gt.reload();
            }
        }));
        pr.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){ //Printer printer=null;
            @SuppressWarnings("null")
                //PageLayout lay=printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
            PrinterJob job=PrinterJob.createPrinterJob();
            if(job!=null && job.showPrintDialog(Stage)){
                gt.print(job); job.endJob();
            }
            }
        }));
        
        web.setOnMouseClicked(e->webap.setRight(null)); //Document doc=gt.getDocument(); File f=(File) gt.getDocument();
        //FileReader rd=new FileReader(f); String r=null; rd.read(r.toCharArray());
        
        hst.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                //reading 
                /*ComboBox<Entry> hstlst=new ComboBox();hstlst.setPrefWidth(150);hstlst.setItems(his.getEntries());hstlst.setPromptText("Browser History");
                hstlst.setStyle("-fx-font:normal 15px 'Cambria'");*/
                
                //making list history
                List<String> hss=new ArrayList(); 
                //reading history file 
                try {
                FileInputStream fin=new FileInputStream("history.dll");
                ObjectInputStream obii=new ObjectInputStream(fin);
                pro=new Properties(); pro=(Properties) obii.readObject();
                Set set=pro.keySet(); Iterator it=set.iterator();
                while(it.hasNext()){
                    hss.add(it.next().toString());
                }
                ObservableList<String> obhs=FXCollections.observableArrayList(hss); ListView hstlst=new ListView(obhs);
                hstlst.setPrefWidth(335); hstlst.setPrefHeight(700);
                hstlst.setStyle("-fx-control-inner-background:navy; -fx-font:normal 15px 'Cambria'");
                
                Label hs=new Label("History");hs.setStyle("-fx-font:bold 20px 'Cambria'");
                VBox histbox=new VBox();histbox.setPadding(new Insets(3,3,3,3));histbox.getChildren().addAll(hs,hstlst);
                histbox.setStyle("-fx-border-color:black");webap.setRight(histbox);
                
                //taking action 
                hstlst.setOnMouseClicked((ect)->{
                    if(ect.getClickCount()==2){
                        String ttt=hstlst.getSelectionModel().getSelectedItem().toString();
                        String url=pro.getProperty(ttt); 
                        log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); webap.setRight(null);
                        gt.load(url);
                    }
                    });
                
                //setting cell options
                hstlst.setCellFactory(httr->{
                    ListCell<String> cell=new ListCell();
                    ContextMenu cui=new ContextMenu();
                    MenuItem opn=new MenuItem(); opn.textProperty().bind(Bindings.format("Open")); opn.setStyle("-fx-font:bold 14px 'Cambria'");
                    MenuItem opndk=new MenuItem(); opndk.textProperty().bind(Bindings.format("Open with Desktop")); 
                    opndk.setStyle("-fx-font:bold 14px 'Cambria'");
                    MenuItem rml=new MenuItem(); rml.textProperty().bind(Bindings.format("Remove from history"));
                    rml.setStyle("-fx-font:bold 14px 'Cambria'");
                    
                    //actions
                    opn.setOnAction((ActionEvent ii)->{
                        String ttt=hstlst.getSelectionModel().getSelectedItem().toString();
                        String url=pro.getProperty(ttt); 
                        log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); webap.setRight(null);
                        gt.load(url);
                    });
                    opndk.setOnAction((ActionEvent sel)->{
                        String ttt=hstlst.getSelectionModel().getSelectedItem().toString();
                        String url=pro.getProperty(ttt);
                        service.showDocument(url);
                    });
                    rml.setOnAction((ActionEvent del)->{
                        pro.remove(hstlst.getSelectionModel().getSelectedItem().toString());
                        hstlst.getItems().remove(hstlst.getSelectionModel().getSelectedItem().toString());
                        //writing new hst file
                        try {
                            FileOutputStream outi=new FileOutputStream("history.dll");
                            ObjectOutputStream objt=new ObjectOutputStream(outi);
                            objt.writeObject(pro); objt.flush(); objt.close(); outi.close();
                            
                        } catch (FileNotFoundException exx){
                            System.out.println("Error finding file....");
                        } catch (IOException ex) {
                            Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    cui.getItems().addAll(opn,opndk,rml);
                    cell.textProperty().bind(cell.itemProperty());
                    cell.emptyProperty().addListener((obs,wasEmpty,isNowEmpty)->{
                        if(isNowEmpty){
                            opn.setDisable(true); opndk.setDisable(true); rml.setDisable(true);
                        } else {
                            opn.setDisable(false); opndk.setDisable(false); rml.setDisable(false); cell.setContextMenu(cui);
                        }
                    });
                    return cell;
                    
                });
                
                } catch (FileNotFoundException ex){
                    System.out.println("Error reading file.....");
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*hstlst.setCellFactory((ListView<WebHistory.Entry> list) -> {
                ListCell<Entry> cell = new ListCell<Entry>()
                {
                @Override
                public void updateItem(Entry item, boolean empty)
                {
                super.updateItem(item, empty);
                if (empty)
                {
                this.setText(null);
                this.setGraphic(null);
                }
                else
                {
                String pageTitle = item.getTitle();
                this.setText(pageTitle);
                }
                }
                };
                return cell;
                });
                hstlst.setOnAction((new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent ev2){
                int cind=his.getCurrentIndex(); Entry sel=hstlst.getValue();int selind=hstlst.getItems().indexOf(sel);
                int offset=selind-cind; log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); his.go(offset);
                }
                }));*/ 
                
                /*hstlst.setCellFactory((ListView<WebHistory.Entry> list) -> {
                    ListCell<Entry> cell = new ListCell<Entry>()
                    {
                        @Override
                        public void updateItem(Entry item, boolean empty)
                        {
                            super.updateItem(item, empty);
                            if (empty)
                            {
                                this.setText(null);
                                this.setGraphic(null);
                            }
                            else
                            {
                                String pageTitle = item.getTitle();
                                this.setText(pageTitle);
                            }
                        }
                    };
                    return cell;
                });
                hstlst.setOnAction((new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent ev2){
                        int cind=his.getCurrentIndex(); Entry sel=hstlst.getValue();int selind=hstlst.getItems().indexOf(sel);
                        int offset=selind-cind; log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); his.go(offset);
                    }
                }));*/
            }
        }));
        open.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            @SuppressWarnings("null")
            public void handle(ActionEvent ev){
                FileChooser chs=new FileChooser(); chs.getExtensionFilters().add(new FileChooser.ExtensionFilter("WebPage", "*.html"));
                chs.setTitle("Open WebPage"); File file=chs.showOpenDialog(Stage); 
                try {
                    URL path=file.toURI().toURL(); if(file!=null){log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);
                    log.add(web,0,0);gt.load(path.toString());}
                    /*if(path.toString().endsWith(".pdf")){
                        pdf.openPdfFile(path.toString());// BufferedImage i=pdf.getPageAsImage(0)
                    }*/
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
            }
        }));
        set.setOnAction((new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent ev){
            Label sett=new Label("Settings");sett.setStyle("-fx-font:bold 22px 'Cambria'");
            Label them=new Label("Theme");them.setStyle("-fx-font:bold 17px 'Cambria'");
            Label zoom=new Label("Zoom");zoom.setStyle("-fx-font:bold 17px 'Cambria'");
            
            ChoiceBox thm=new ChoiceBox();thm.getItems().addAll("Transparent","Normal","Dark");//thm.setPrefWidth(200);
            ChoiceBox zm=new ChoiceBox();zm.getItems().addAll("Smaller","Normal","Bigger");//zm.setPrefWidth(200);
            thm.setStyle("-fx-font:normal 15px 'Cambria'"); zm.setStyle("-fx-font:normal 15px 'Cambria'");
            
            Button apply=new Button("Apply");apply.setStyle("-fx-background-color:darkgreen;-fx-text-fill:aliceblue;-fx-font:bold 25px 'Cambria'");
            apply.setPrefSize(200,50);
            
            GridPane stt=new GridPane();stt.setPadding(new Insets(5,5,5,5));stt.setVgap(7);stt.setHgap(7);stt.setStyle("-fx-border-color:grey");
            stt.add(sett,0,0);stt.add(them,0,3);stt.add(thm,0,5);stt.add(zoom,0,8);stt.add(zm,0,10);stt.add(apply,0,15);webap.setRight(stt);
            
            apply.setOnAction((new EventHandler<ActionEvent>(){
                @Override
                @SuppressWarnings("ConvertToTryWithResources")
                public void handle(ActionEvent ev){
                    String thmset=thm.getValue().toString(); String zmset=zm.getValue().toString();
                    if(thmset.equals("Transparent")){ try{
                        Stage.setOpacity(0.9); pro.put("transparent","yes");
                        FileOutputStream fout=new FileOutputStream("theme.bat");
                        ObjectOutputStream obout=new ObjectOutputStream(fout);
                        obout.writeObject(pro); fout.close(); obout.close();
                    } catch (FileNotFoundException ex){
                        System.out.println("Erro allocating file....");
                    }   catch (IOException ex) {
                            Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    if(thmset.equals("Normal")){
                        st.setBackground(bg1);tabp.setBackground(null); webap.setBackground(bg);
                        Stage.setOpacity(1);hg.setBackground(bg2); pro.put("theme", "normal"); pro.put("transparent","no");
                        try {
                        FileOutputStream fout=new FileOutputStream("theme.bat");
                        ObjectOutputStream obout=new ObjectOutputStream(fout);
                        obout.writeObject(pro); fout.close(); obout.close();
                        } catch (FileNotFoundException ex){
                            System.out.println("File not found....");
                        }catch (IOException ex) {
                            Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    if(thmset.equals("Dark")){
                        st.setBackground(bg5);tabp.setBackground(bg4);
                        Stage.setOpacity(1);hg.setBackground(bg5); pro.put("theme", "dark"); pro.put("transparent","no");
                        try {
                        FileOutputStream fout=new FileOutputStream("theme.bat");
                        ObjectOutputStream obout=new ObjectOutputStream(fout);
                        obout.writeObject(pro); fout.close(); obout.close();
                        } catch (FileNotFoundException ex){
                            System.out.println("File not found....");
                        }catch (IOException ex) {
                            Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    if(zmset.equals("Smaller")){web.setFontScale(web.getFontScale()-0.2);web.setZoom(web.getZoom()-0.2);}
                    if(zmset.equals("Normal")){web.setFontScale(1);web.setZoom(1);}
                    if(zmset.equals("Bigger")){web.setFontScale(web.getFontScale()+0.2);web.setZoom(web.getZoom()+0.2);} webap.setRight(null);
                }
            }));
        }
    }));
        abt.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                String about="Developed and published by SeumX Plus Uganda.\nThis software is freely available for download on"
                        + " SeumX Store for installation and updates.\nFor more information and updates, you can vist our : "
                        + "http://www.seumxplus.org  \n And for help, you can send us an email on : "
                        + "seumxplus2019@gmail.com   \n   Software Developer : Muwanguzi Silas\n"
                        + "   Software Company : SeumX Plus\n   Software Publisher : SeumX Plus";
                Label ab=new Label(about);ab.setStyle("-fx-font:normal 17px 'Cambria';-fx-text-fill:white;");
                ImageView view=new ImageView(icon);view.setFitHeight(400);view.setFitWidth(400);GridPane hy=new GridPane();
                hy.setStyle("-fx-background-color:darkred"); hy.add(view,0,0);hy.add(ab,0,1); ScrollPane pn=new ScrollPane(hy);
                pn.prefHeightProperty().bind(Stage.heightProperty()); pn.prefWidthProperty().bind(Stage.widthProperty());
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(pn,0,0);
            }
        }));
        
        music.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); gt.load("http://www.mp3juices.cc");
            }
        }));
        
        movie.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); gt.load("http://www.imdb.com");
            }
        }));
        
        news.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); 
                gt.load("http://news.google.co.ug/nwshp?hl=en&tab=wn");
            }
        }));
        
        book.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); 
                gt.load("http://www.pdfdrive.com");
            }
        }));
        
        hlp.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web, 0, 0);
                gt.load(url.toString());tab.setText("Help_doc");
            }
        }));
        
        down.setOnAction((new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent ev){
                FileChooser ch=new FileChooser();ch.getExtensionFilters().add(new FileChooser.ExtensionFilter("WebPage", ".html"));
                File ini=new File("C:/Users");ch.setInitialDirectory(ini);ch.setInitialFileName(gt.getTitle());
                File file=ch.showSaveDialog(Stage); 
                try {URL sti=new URL(gt.getLocation());
                    if(file!=null){FileUtils.copyURLToFile(sti, file,789,789);
                    }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }));
        
        stp.setOnAction((ActionEvent evv)->{
            ind.setProgress(0); load.setValue(0); gt.getLoadWorker().cancel(); stp.setDisable(true);
        });
        
        dsk.setOnAction((ActionEvent evv)->{
            service.showDocument(entry.getText()); 
        });
        
        adb.setOnAction((ActionEvent evf)->{
            //reading the bk file
            try {
                FileInputStream inol=new FileInputStream("bookmrk.dll");
                ObjectInputStream objf=new ObjectInputStream(inol);
                pro=new Properties(); pro=(Properties) objf.readObject();
                pro.put(gt.getTitle(), entry.getText());
                //writing bookmarks file
                FileOutputStream ouy=new FileOutputStream("bookmrk.dll");
                ObjectOutputStream objk=new ObjectOutputStream(ouy);
                objk.writeObject(pro); objk.flush(); objk.close(); ouy.close();
                
            } catch (FileNotFoundException exx){
                System.out.println("Error reading file...");
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        bkm.setOnAction((ActionEvent efd)->{
            //reading bks
            try {
                FileInputStream inop=new FileInputStream("bookmrk.dll");
                ObjectInputStream objl=new ObjectInputStream(inop); 
                pro=new Properties(); pro=(Properties) objl.readObject(); Set sttl=pro.keySet(); List bkll=new ArrayList();
                Iterator it= sttl.iterator();
                while(it.hasNext()){
                    bkll.add(it.next());
                }
                ObservableList<String> obser=FXCollections.observableArrayList(bkll);
                ListView view=new ListView(obser); view.setPrefWidth(335); view.setPrefHeight(700);
                view.setStyle("-fx-control-inner-background:darkgreen; -fx-font:normal 15px 'Cambria'");
                
                //factory
                view.setCellFactory(httr->{
                    ListCell<String> cell=new ListCell();
                    ContextMenu cui=new ContextMenu();
                    MenuItem opn=new MenuItem(); opn.textProperty().bind(Bindings.format("Open")); opn.setStyle("-fx-font:bold 14px 'Cambria'");
                    MenuItem opndk=new MenuItem(); opndk.textProperty().bind(Bindings.format("Open with Desktop")); 
                    opndk.setStyle("-fx-font:bold 14px 'Cambria'");
                    MenuItem rml=new MenuItem(); rml.textProperty().bind(Bindings.format("Remove bookmark"));
                    rml.setStyle("-fx-font:bold 14px 'Cambria'");
                    
                    //actions
                    opn.setOnAction((ActionEvent ii)->{
                        String ttt=view.getSelectionModel().getSelectedItem().toString();
                        String url2=pro.getProperty(ttt); 
                        log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); webap.setRight(null);
                        gt.load(url2);
                    });
                    opndk.setOnAction((ActionEvent sel)->{
                        String ttt=view.getSelectionModel().getSelectedItem().toString();
                        String url2=pro.getProperty(ttt); 
                        service.showDocument(url2);
                    });
                    rml.setOnAction((ActionEvent del)->{
                        try {
                        pro.remove(view.getSelectionModel().getSelectedItem().toString());
                        view.getItems().remove(view.getSelectionModel().getSelectedItem().toString());
                        //writing new hst file
                            FileOutputStream outi=new FileOutputStream("bookmrk.dll");
                            ObjectOutputStream objt=new ObjectOutputStream(outi);
                            objt.writeObject(pro); objt.flush(); objt.close(); outi.close();
                            
                        } catch (FileNotFoundException exx){
                            System.out.println("Error finding file....");
                        } catch (IOException ex) {
                            Logger.getLogger(SkyBrowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                    cui.getItems().addAll(opn,opndk,rml);
                    cell.textProperty().bind(cell.itemProperty());
                    cell.emptyProperty().addListener((obs,wasEmpty,isNowEmpty)->{
                        if(isNowEmpty){
                            opn.setDisable(true); opndk.setDisable(true); rml.setDisable(true);
                        } else {
                            opn.setDisable(false); opndk.setDisable(false); rml.setDisable(false); cell.setContextMenu(cui);
                        }
                    });
                    return cell;
                    
                });
                view.setOnMouseClicked((ect)->{
                    if(ect.getClickCount()==2){
                        String ttt=view.getSelectionModel().getSelectedItem().toString();
                        String urle=pro.getProperty(ttt); 
                        log.getChildren().clear();tabp.getTabs().clear();tabp.getTabs().add(tab);log.add(web,0,0); webap.setRight(null);
                        gt.load(urle);
                    }
                    });
                
                Label bkk=new Label("Bookmarks"); bkk.setStyle("-fx-font:bold 18px 'Cambria'; -fx-text-fill:navy");
                VBox bxx=new VBox(); bxx.setPadding(new Insets(3)); bxx.setStyle("-fx-border-color:black");
                bxx.getChildren().addAll(bkk,view); webap.setRight(bxx);
                
            } catch (FileNotFoundException ex){
                System.out.println("Error reading file....");
            } catch (IOException | ClassNotFoundException exk){
                System.out.println("Class | IO except.....");
            }
        });
        
        dwn.setOnAction((ActionEvent ev)->{
            webap.setRight(uio);
        });
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
