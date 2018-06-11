package pkg_relatorio_vendas;
import java.io.*;

public class FindFilesWithThisExtn {
		
		//extension you want to search for e.g. .png, .jpeg, .xml etc
		private static final String searchThisExtn = ".dat";

		//specify the path (folder) where you want to search files
		String home_path = Relatorio_Vendas.home_path;
		String fileLocation  = Relatorio_Vendas.fileLocation +"\\in";
		
		public String[] listFiles() throws DirectNotFoundException, NofilesWithExtensionException{

			SearchFiles files = new SearchFiles(searchThisExtn);

			File folder = new File(fileLocation);

			if(folder.isDirectory()==false){
				throw new DirectNotFoundException("Folder does not exists: " + fileLocation);
			}

			String[] list = folder.list(files);

			if (list.length == 0) {
				throw new NofilesWithExtensionException("File with extension not found");
			}

			return list;
			
		}
		
}
