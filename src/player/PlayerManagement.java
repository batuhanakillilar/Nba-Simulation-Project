package player;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PlayerManagement {
	
		public static ArrayList<C> CenterPlayers;
		public static ArrayList<PF> PowerForwards;
		public static ArrayList<PG> PointGuards;
		public static ArrayList<SG> ShootingGuards;
		public static ArrayList<SF> SmallForwards;
		public static ArrayList<Player> AllPlayers;
		
	
		public PlayerManagement() {
			
			CenterPlayers = new ArrayList<>();
			PowerForwards = new ArrayList<>();
			PointGuards = new ArrayList<>();
			ShootingGuards = new ArrayList<>();
			SmallForwards = new ArrayList<>();
			AllPlayers = new ArrayList<>();
		}
		
		
		/**
		 * A method to read data file, create right player objects, erase duplicate entries and add them to their arraylists.
		 */

		public void PlayerCreation(){
			
			ArrayList<String> player_names = new ArrayList<String>();
			
			try {
				

				BufferedReader reader = new BufferedReader(new FileReader("2022-2023 NBA Player Stats - Regular.csv"));
				String line;
			
				while((line = reader.readLine()) != null) {
					
					String[] list = line.split(";");
					
						
					if(list[2].equals("C")) {
						//1,29,23,24,26,25
						C center = new C(list[1],Double.parseDouble(list[29]),Double.parseDouble(list[23]),Double.parseDouble(list[24]),Double.parseDouble(list[26]),Double.parseDouble(list[25]));
						
						if(!player_names.contains(center.getName())) {
							CenterPlayers.add(center);
							AllPlayers.add(center);
							player_names.add(center.getName());
								
								
						}	
						
							
						
					}
					
					if(list[2].equals("PF")) {
						//1,29,23,24,26,25
						PF powerforward = new PF(list[1],Double.parseDouble(list[29]),Double.parseDouble(list[23]),Double.parseDouble(list[24]),Double.parseDouble(list[26]),Double.parseDouble(list[25]));
						if(!player_names.contains(powerforward.getName())) {
							PowerForwards.add(powerforward);
							AllPlayers.add(powerforward);
							player_names.add(powerforward.getName());
						}
						
					
					}
					
					
					if(list[2].equals("PG")) {
						//1,29,23,24,26,25
						PG pointguard = new PG(list[1],Double.parseDouble(list[29]),Double.parseDouble(list[23]),Double.parseDouble(list[24]),Double.parseDouble(list[26]),Double.parseDouble(list[25]));
						if(!player_names.contains(pointguard.getName())) {
							PointGuards.add(pointguard);
							AllPlayers.add(pointguard);
							player_names.add(pointguard.getName());

						}
						
					}
					
					
					if(list[2].equals("SF")) {
						//1,29,23,24,26,25
						SF smallforward = new SF(list[1],Double.parseDouble(list[29]),Double.parseDouble(list[23]),Double.parseDouble(list[24]),Double.parseDouble(list[26]),Double.parseDouble(list[25]));
						if(!player_names.contains(smallforward.getName())) {
							SmallForwards.add(smallforward);
							AllPlayers.add(smallforward);
							player_names.add(smallforward.getName());
							
						}
						
					}
					
					if(list[2].equals("SG")) {
						//1,29,23,24,26,25
						SG shootingguard = new SG(list[1],Double.parseDouble(list[29]),Double.parseDouble(list[23]),Double.parseDouble(list[24]),Double.parseDouble(list[26]),Double.parseDouble(list[25]));
						if(!player_names.contains(shootingguard.getName())) {
							ShootingGuards.add(shootingguard);
							AllPlayers.add(shootingguard);
							player_names.add(shootingguard.getName());
							
						}
						
					
					}
					
				}
				
				reader.close();
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			

			
		}

		
		
		

	

}
