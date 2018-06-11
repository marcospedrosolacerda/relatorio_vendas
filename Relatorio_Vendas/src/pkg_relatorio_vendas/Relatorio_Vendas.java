package pkg_relatorio_vendas;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;


public class Relatorio_Vendas {
	
	//specify the path (folder) where you want to search files
	public static final String home_path = System.getProperty("user.home");
	public static final String fileLocation = home_path+"\\data";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Teste");
		
		
		FindFilesWithThisExtn obj = new FindFilesWithThisExtn();
		//loop - Checking .dat files
		while (true) {
			try {
				String[] list = obj.listFiles();
				
				//loop to go through the files 
				for (String file: list) {
					
					ArrayList<Cliente> Arl_Cliente=new ArrayList<Cliente>();//Creating Cliente arraylist
					ArrayList<Vendedor> Arl_Vendedor=new ArrayList<Vendedor>();//Creating Vendedor arraylist
					ArrayList<Vendas> Arl_Vendas=new ArrayList<Vendas>();//Creating Vendas arraylist
					//TODO : Remove this
					System.out.println(file); 
					
					try {
						InputStream is = new FileInputStream(fileLocation + "\\in\\" + file);
						InputStreamReader isr = new InputStreamReader(is);
						BufferedReader br = new BufferedReader(isr);
						
						//read lines
						String s;
						 do {
							
							s = br.readLine();
							if (s!= null) {
								
								String [] str_arr = s.split("ç"); //ç separated values
								
									
								if (str_arr[0].equals("001")) {//test if Dados Vendedor
									Vendedor ven = new Vendedor();
									ven.setCpf(Long.parseLong((String)str_arr[1]));
									ven.setName((String)str_arr[2]);
									ven.setSalary(Double.parseDouble((String)str_arr[3]));
									
									Arl_Vendedor.add(ven);
									
								}
								else if (str_arr[0].equals("002")) { //test if Dados cliente
									Cliente cli = new Cliente();
									cli.setCnpj(Long.parseLong((String)str_arr[1]));
									cli.setName((String)str_arr[2]);
									cli.setBusinessarea((String)str_arr[3]);
									
									Arl_Cliente.add(cli);
								}
								else if (str_arr[0].equals("003")) {//test if Dados Vendas
									Vendas ven = new Vendas();
									ven.setSale_id(Long.parseLong((String)str_arr[1]));
									ven.setSalesman_name((String)str_arr[3]);
									
									String lista_itens = str_arr[2].replace("[", "");
									lista_itens = lista_itens.replace("]", "");
									
									String [] itens_linha = lista_itens.split(",");
									
									ArrayList <Venda_Item> arl_vi = new ArrayList<Venda_Item>();
									
									for (String item :itens_linha) {
										String[] arr_item= item.split("-");
										
										Venda_Item vi = new Venda_Item();
										vi.setItem_id(Long.parseLong(arr_item[0]));
										vi.setItem_qty(Long.parseLong(arr_item[1]));
										vi.setItem_price(Double.parseDouble(arr_item[2]));
										
										arl_vi.add(vi);
										
									}
									ven.setVenda_Item(arl_vi);
									
									Arl_Vendas.add(ven);
								}
								else;
								
							}
							
						} while (s != null); //End loop read lines
						
						br.close();
					
					} catch (FileNotFoundException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					
					//process results
					Resultado_Relatorio res = new Resultado_Relatorio();
					
					int qtd_cli=0;
					for(Cliente cli1:Arl_Cliente) {
						 qtd_cli +=1;
						    
					} 
					
					int qtd_ven=0;
					for(Vendedor ven1:Arl_Vendedor) {
						 qtd_ven +=1;
						    
					} 
					
					long id_vendamaiscara =0;
					
					double vlr_venda_mais_cara = 0;
					for (Vendas ven:Arl_Vendas) {
						
						double vlr_venda = 0;
						for (Venda_Item vi:ven.getVenda_Item()) {
							vlr_venda += vi.getItem_price() * vi.getItem_qty();
						}
						
						if (vlr_venda > vlr_venda_mais_cara) {
							id_vendamaiscara = ven.getSale_id();
							vlr_venda_mais_cara = vlr_venda;
						}
					}
					
					res.setQuantidade_clientes(qtd_cli);
					res.setQuantidade_vendedores(qtd_ven);
					res.setId_vendamaiscara(String.valueOf(id_vendamaiscara));
					
					//Writing  flat file done
					try {
						OutputStream os = new FileOutputStream(fileLocation + "\\out\\" + file.substring(0,file.indexOf(".") )+".done.dat");
						OutputStreamWriter osw = new OutputStreamWriter(os);
						BufferedWriter bw = new BufferedWriter(osw);
						
						bw.write("Quantidade de clientes no arquivo de entrada:"+ Integer.toString(res.getQuantidade_clientes()));
						bw.newLine();
						bw.write("Quantidade de Vendedores no arquivo de entrada:"+ Integer.toString(res.getQuantidade_vendedores()));
						bw.newLine();
						bw.write("Id da Venda mais cara: "+ res.getId_vendamaiscara());
						bw.close();
					
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					//move file to out folder
					File file_out = new File(fileLocation + "\\in\\" + file);
					file_out.renameTo(new File(fileLocation + "\\out\\" + file));

					
				} // End loop go through files
				
				
			} catch (DirectNotFoundException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
			catch (NofilesWithExtensionException e) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			
			//Sleeps for 5 sec 
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		} // End Loop Checking .dat files

	}

}

	
	
	