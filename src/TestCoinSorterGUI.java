//TestCoinSorterGUI class - Assignment 1

import java.util.ArrayList;

import javafx.application.Application; 
import javafx.geometry.Pos;
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.control.Label; 
import javafx.scene.control.TextArea; 
import javafx.scene.control.TextField; 
import javafx.scene.layout.HBox; 
import javafx.scene.layout.VBox; 
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage; 
	
public class TestCoinSorterGUI extends Application {
	
	Scene mainScene, scene1, scene2, scene3, scene4, scene5, scene6, sceneSub1, sceneSub2, sceneSub3;
	
	public void start(Stage stage)     
	{	//Main Scene
		
		// Create a list of denominations to be passed as argument in the constructor
		ArrayList<Integer> clist=new ArrayList<>();
		clist.add(200);
		clist.add(100);
		clist.add(50);
		clist.add(20);
		clist.add(10);
		
		// Create a list of denominations to be passed as argument in the constructor
		CoinSorter cs=new CoinSorterGUI("Pound Sterling", 0, 10000, clist);
		
		//Main menu label     
		Label coinSorterMenu = new Label("***Coin Sorter - Main Menu***");         
		coinSorterMenu.setTextFill(Color.ROYALBLUE);         
		coinSorterMenu.setFont(Font.font("Calibri", 22));         
		
		//Buttons of main menu         
		Button coinCalculator = new Button();    
		coinCalculator.setStyle("-fx-background-color: #FFD700; ");
		coinCalculator.setText("1 - Coin calculator");
		coinCalculator.setOnAction( e -> stage.setScene(scene1));
		
		Button multiCoinCalculator = new Button();     
		multiCoinCalculator.setStyle("-fx-background-color: #FFD700; ");
		multiCoinCalculator.setText("2 - Multiple coin calculator");
		multiCoinCalculator.setOnAction( e -> stage.setScene(scene2));
		
		Button printList = new Button();
		printList.setStyle("-fx-background-color: #FFD700; ");
		printList.setText("3 - Print coin list");
		printList.setOnAction( e -> stage.setScene(scene3));
		
		Button setDetails = new Button();  
		setDetails.setStyle("-fx-background-color: #FFD700; ");
		setDetails.setText("4 - Set details");
		setDetails.setOnAction( e -> stage.setScene(scene4));
		
		Button displayConfigs = new Button();  
		displayConfigs.setStyle("-fx-background-color: #FFD700; ");
		displayConfigs.setText("5 - Display program configurations");
		displayConfigs.setOnAction( e -> stage.setScene(scene5));
		
		Button quit = new Button();   
		quit.setStyle("-fx-background-color: #FFD700; ");
		quit.setText("6 - Quit the program");
		quit.setOnAction( e -> stage.setScene(scene6));
		
		//HBox for main menu                      
		HBox mainMenu = new HBox();
		mainMenu.setSpacing(10.0);
		mainMenu.setAlignment(Pos.CENTER);
		mainMenu.getChildren().addAll(coinCalculator,multiCoinCalculator,printList,setDetails,displayConfigs,quit); 
		
		// VBox for main menu         
		VBox root = new VBox(40);         
		root.setAlignment(Pos.CENTER); 
		root.setStyle("-fx-background-color: #98FB98;");
		root.setSpacing(60);
		root.getChildren().addAll(coinSorterMenu,mainMenu); 
		
		//Scene 1 (Coin calculator)

		Label coinCalc = new Label("-Single Coin Calculator-");         
		coinCalc.setTextFill(Color.CORNFLOWERBLUE);         
		coinCalc.setFont(Font.font("Calibri", 22));  
		
		TextField value = new TextField();         
		value.setMaxWidth(80);   
		
		TextField coinType = new TextField();         
		coinType.setMaxWidth(80);
		
		TextArea result = new TextArea();        
		result.setEditable(false);               
		result.setMaxSize(400,50); 
		
		Label valueLabel = new Label("Value:       ");         
		valueLabel.setTextFill(Color.BLACK);         
		valueLabel.setFont(Font.font("Calibri", 18));    
		
		Label coinTypeLabel= new Label("Coin Type:");         
		coinTypeLabel.setTextFill(Color.BLACK);         
		coinTypeLabel.setFont(Font.font("Calibri", 18));
		
		Button sortCoinsButton = new Button();         
		sortCoinsButton.setText("Sort in this coin"); 
		sortCoinsButton.setStyle("-fx-background-color: #00FF7F; ");
		sortCoinsButton.setOnAction( e ->
										{
										 if (value.getText().isEmpty() || coinType.getText().isEmpty())        
										   {
											 result.setText("Please enter a valid value.");                       
										   }
										 else if (Integer.parseInt(value.getText())<cs.getMinCoinIn() || Integer.parseInt(value.getText())>cs.getMaxCoinIn())
											 {
											 result.setText("Please enter a value within the set range.");
											 }
										 else if ((Integer.parseInt(coinType.getText())!=200)&&(Integer.parseInt(coinType.getText())!=100)&&
										 		 		(Integer.parseInt(coinType.getText())!=50)&&(Integer.parseInt(coinType.getText())!=20)&&
										 		 			(Integer.parseInt(coinType.getText())!=10))
										 	 {
											 result.setText("Please choose a valid coin denomination.");
										 	 }
										 else 
										 	 {
											 result.setText(cs.coinCalculator(Integer.parseInt(value.getText()), Integer.parseInt(coinType.getText())));

											 }
										} 
										);
		
		Button mainMenuReturn1 = new Button();  
		mainMenuReturn1.setStyle("-fx-background-color: #FFB6C1; ");
		mainMenuReturn1.setText("Return to main menu");
		mainMenuReturn1.setOnAction( e -> stage.setScene(mainScene));
		
		HBox menu1= new HBox(10);
		menu1.setAlignment(Pos.CENTER);
		menu1.getChildren().addAll(valueLabel,value);
		
		HBox menu2= new HBox(10);
		menu2.setAlignment(Pos.CENTER);
		menu2.getChildren().addAll(coinTypeLabel,coinType);
		
		VBox root1 = new VBox(40);         
		root1.setAlignment(Pos.CENTER); 
		root1.setStyle("-fx-background-color: #F0E68C;");
		root1.setSpacing(25.0);
		root1.getChildren().addAll(coinCalc,menu1,menu2,result,sortCoinsButton,mainMenuReturn1);
		
		scene1 = new Scene(root1, 700, 400);
		
		//Scene 2 (Multi Coin calculator)
		
		Label multiCoinCalc = new Label("-Multiple Coins Calculator-");         
		multiCoinCalc.setTextFill(Color.DARKORANGE);         
		multiCoinCalc.setFont(Font.font("Calibri", 22)); 
		
		TextField valueMulti = new TextField();         
		valueMulti.setMaxWidth(80);  
		
		TextField multiCoinType = new TextField();         
		multiCoinType.setMaxWidth(80);
		
		TextArea multiResult = new TextArea();        
		multiResult.setEditable(false);               
		multiResult.setMaxSize(550,50);
		
		Label multiValueLabel = new Label("Value:       ");         
		multiValueLabel.setTextFill(Color.BLACK);         
		multiValueLabel.setFont(Font.font("Calibri", 18)); 
		
		Label multiCoinTypeLabel= new Label("Coin Type:");         
		multiCoinTypeLabel.setTextFill(Color.BLACK);         
		multiCoinTypeLabel.setFont(Font.font("Calibri", 18));
		
		Button multiSortCoinsButton = new Button();         
		multiSortCoinsButton.setText("Sort excluding this coin"); 
		multiSortCoinsButton.setStyle("-fx-background-color: #00FF7F; ");
		multiSortCoinsButton.setOnAction( e ->
											{
												if (valueMulti.getText().isEmpty() || multiCoinType.getText().isEmpty())        
												{
													multiResult.setText("Please enter a valid value.");                       
												}
												else if (Integer.parseInt(valueMulti.getText())<cs.getMinCoinIn() || Integer.parseInt(valueMulti.getText())>cs.getMaxCoinIn())
												 {
													multiResult.setText("Please enter a value within the set range.");
												 }
												else if ((Integer.parseInt(multiCoinType.getText())!=200)&&(Integer.parseInt(multiCoinType.getText())!=100)&&
										 		 		(Integer.parseInt(multiCoinType.getText())!=50)&&(Integer.parseInt(multiCoinType.getText())!=20)&&
									 		 			(Integer.parseInt(multiCoinType.getText())!=10))
											 	 {
													multiResult.setText("Please choose a valid coin denomination.");
											 	 }
												else
												{
													multiResult.setText(cs.multiCoinCalculator(Integer.parseInt(valueMulti.getText()), 
															Integer.parseInt(multiCoinType.getText())));
												}
												} 
												);
		Button mainMenuReturn2 = new Button();  
		mainMenuReturn2.setStyle("-fx-background-color: #FFB6C1; ");
		mainMenuReturn2.setText("Return to main menu");
		mainMenuReturn2.setOnAction( e -> stage.setScene(mainScene));
		
		HBox menu3= new HBox(10);
		menu3.setAlignment(Pos.CENTER);
		menu3.getChildren().addAll(multiValueLabel,valueMulti);
		
		HBox menu4= new HBox(10);
		menu4.setAlignment(Pos.CENTER);
		menu4.getChildren().addAll(multiCoinTypeLabel,multiCoinType);
		
		VBox root2 = new VBox(40);         
		root2.setAlignment(Pos.CENTER); 
		root2.setStyle("-fx-background-color: #F0E68C;");
		root2.setSpacing(25.0);
		root2.getChildren().addAll(multiCoinCalc,menu3,menu4,multiResult,multiSortCoinsButton,mainMenuReturn2);
		
		scene2 = new Scene(root2, 700, 400);
		
		//Scene 3 (Print coin list)
		
		Label main = new Label("-Coin List-");         
		main.setTextFill(Color.CRIMSON);         
		main.setFont(Font.font("Calibri", 22)); 
		
		Label printCoinList = new Label("The current coin denominations are in circulation: "+cs.printCoinList());         
		printCoinList.setTextFill(Color.BLACK);         
		printCoinList.setFont(Font.font("Calibri", 15)); 
		
		Button mainMenuReturn3 = new Button();  
		mainMenuReturn3.setStyle("-fx-background-color: #FFB6C1; ");
		mainMenuReturn3.setText("Return to main menu");
		mainMenuReturn3.setOnAction( e -> stage.setScene(mainScene));
		
		VBox root3 = new VBox(20);         
		root3.setAlignment(Pos.CENTER); 
		root3.setStyle("-fx-background-color: #B0E0E6;");
		root3.getChildren().addAll(main,printCoinList,mainMenuReturn3);
				
		scene3 = new Scene(root3, 600, 200);
		
		//Scene 4 (Set details with sub-scenes)
		
		
		Label subMenu = new Label("***Set Details Sub-Menu***");         
		subMenu.setTextFill(Color.CRIMSON);         
		subMenu.setFont(Font.font("Calibri", 22)); 
		
		//Buttons of main menu         
		Button setCurrency = new Button();    
		setCurrency.setStyle("-fx-background-color: #90EE90; ");
		setCurrency.setText("1 - Set currency");
		setCurrency.setOnAction( e -> stage.setScene(sceneSub1));
				
		Button setMinInput = new Button();     
		setMinInput.setStyle("-fx-background-color: #90EE90; ");
		setMinInput.setText("2 - Set minimum coin input value");
		setMinInput.setOnAction( e -> stage.setScene(sceneSub2));
				
		Button setMaxInput = new Button();
		setMaxInput.setStyle("-fx-background-color: #90EE90; ");
		setMaxInput.setText("3 - Set maximum coin input value");
		setMaxInput.setOnAction( e -> stage.setScene(sceneSub3));
				
		Button returnMain = new Button();  
		returnMain.setStyle("-fx-background-color: #90EE90; ");
		returnMain.setText("4 - Return to main menu");
		returnMain.setOnAction( e -> stage.setScene(mainScene));
		
		VBox rootSubMenu = new VBox(40);         
		rootSubMenu.setAlignment(Pos.CENTER_LEFT); 
		rootSubMenu.setStyle("-fx-background-color: #FFDAB9;");
		rootSubMenu.setSpacing(30);
		rootSubMenu.getChildren().addAll(subMenu,setCurrency,setMinInput,setMaxInput,returnMain); 
		
		scene4 = new Scene(rootSubMenu, 400, 400);
		
		//Scene 5 (Display program configurations )
		
		
		Label displayConfigsLabel = new Label("Press the button to view the current Program configurations.");         
		displayConfigsLabel.setTextFill(Color.CRIMSON);         
		displayConfigsLabel.setFont(Font.font("Calibri", 20));
		
		TextArea configs = new TextArea();        
		configs.setEditable(false);               
		configs.setMaxSize(800,50);
		
		Button configsButton = new Button();    
		configsButton.setStyle("-fx-background-color: #90EE90; ");
		configsButton.setText("Show configs");
		configsButton.setOnAction( e -> {
											configs.setText(cs.displayProgramConfigs());
											}
									  );
		
		
		
		Button mainMenuReturn5 = new Button();  
		mainMenuReturn5.setStyle("-fx-background-color: #FFB6C1; ");
		mainMenuReturn5.setText("Return to main menu");
		mainMenuReturn5.setOnAction( e -> stage.setScene(mainScene));
				
		VBox root5 = new VBox(30);         
		root5.setAlignment(Pos.CENTER);    
		root5.setStyle("-fx-background-color: #F0E68C;");
		root5.getChildren().addAll(displayConfigsLabel,configs,configsButton,mainMenuReturn5);
				
		scene5 = new Scene(root5, 1000, 400);
		
		//Scene 6 (Quit program)
		
		
		Label byeLabel = new Label("Thank you for using Coin Sorter. Goodbye.");         
		byeLabel.setTextFill(Color.	FORESTGREEN);         
		byeLabel.setFont(Font.font("Calibri",18)); 
		
		VBox root6 = new VBox(0);         
		root6.setAlignment(Pos.CENTER);
		root6.setStyle("-fx-background-color: #00000000;");
		root6.getChildren().addAll(byeLabel);
		
		scene6 = new Scene(root6, 500, 300);
		
		// Sub-scenes (3) for sub-menu
		
		//Sub-scene 1 (set currency)
		
		Label setCurrency2 = new Label("Set the currency below.");         
		setCurrency2.setTextFill(Color.	ROYALBLUE);         
		setCurrency2.setFont(Font.font("Calibri", 18));
		
		TextField setCurrencyText = new TextField();         
		setCurrencyText.setMaxWidth(80); 
		
		Button setCurrencyButton = new Button();    
		setCurrencyButton.setStyle("-fx-background-color: #90EE90; ");
		setCurrencyButton.setText("Set currency");
		setCurrencyButton.setOnAction( e -> {
											cs.setCurrency(setCurrencyText.getText());
											}
									  );
		
		Button returnToSub = new Button();  
		returnToSub.setStyle("-fx-background-color: #FFB6C1; ");
		returnToSub.setText("Return to sub menu");
		returnToSub.setOnAction( e -> stage.setScene(scene4));
		
		VBox rootSub1 = new VBox(20);         
		rootSub1.setAlignment(Pos.CENTER);
		rootSub1.setStyle("-fx-background-color: #F0E68C;");
		rootSub1.getChildren().addAll(setCurrency2,setCurrencyText,setCurrencyButton,returnToSub);
				
		sceneSub1 = new Scene(rootSub1, 500, 300);
		
		//Sub-scene 2 (set minimum coin input value)
		
		Label setMinInputValue = new Label("Set the minimum coin input below.");         
		setMinInputValue.setTextFill(Color.	ROYALBLUE);         
		setMinInputValue.setFont(Font.font("Calibri", 18));
					
		TextField setMinInputValueText = new TextField();         
		setMinInputValueText.setMaxWidth(80); 
		
		
		Button setMinInputValueButton = new Button();    
		setMinInputValueButton.setStyle("-fx-background-color: #90EE90; ");
		setMinInputValueButton.setText("Set minimum coin input");
		setMinInputValueButton.setOnAction( e -> {
											cs.setMinCoinIn(Integer.parseInt(setMinInputValueText.getText()));
											}
									  );
		
		Button returnToSub2 = new Button();  
		returnToSub2.setStyle("-fx-background-color: #FFB6C1; ");
		returnToSub2.setText("Return to sub menu");
		returnToSub2.setOnAction( e -> stage.setScene(scene4));
		
		VBox rootSub2 = new VBox(20);         
		rootSub2.setAlignment(Pos.CENTER);
		rootSub2.setStyle("-fx-background-color: #F0E68C;");
		rootSub2.getChildren().addAll(setMinInputValue,setMinInputValueText,setMinInputValueButton,returnToSub2);
		
		sceneSub2 = new Scene(rootSub2, 500, 300);
		
		//Sub-scene 3 (set maximum coin input value)
		
		Label setMaxInputValue = new Label("Set the maximum coin input below.");         
		setMaxInputValue.setTextFill(Color.	ROYALBLUE);         
		setMaxInputValue.setFont(Font.font("Calibri", 18));
					
		TextField setMaxInputValueText = new TextField();         
		setMaxInputValueText.setMaxWidth(80); 
		
		
		Button setMaxInputValueButton = new Button();    
		setMaxInputValueButton.setStyle("-fx-background-color: #90EE90; ");
		setMaxInputValueButton.setText("Set maximum coin input");
		setMaxInputValueButton.setOnAction( e -> {
											cs.setMaxCoinIn(Integer.parseInt(setMaxInputValueText.getText()));
											}
									  );
		
		Button returnToSub3 = new Button();  
		returnToSub3.setStyle("-fx-background-color: #FFB6C1; ");
		returnToSub3.setText("Return to sub menu");
		returnToSub3.setOnAction( e -> stage.setScene(scene4));
		
		VBox rootSub3 = new VBox(20);         
		rootSub3.setAlignment(Pos.CENTER);
		rootSub3.setStyle("-fx-background-color: #F0E68C;");
		rootSub3.getChildren().addAll(setMaxInputValue,setMaxInputValueText,setMaxInputValueButton,returnToSub3);
		
		sceneSub3 = new Scene(rootSub3, 500, 300);
		
		//Main Scene    
		mainScene = new Scene(root, 1050, 300);         
		stage.setScene(mainScene);         
		stage.setTitle("Coin Sorter"); 
		
		stage.show();             
		 
					
	}
	public static void main(String[] args)     
	{         
		launch(args);     
	}

}
