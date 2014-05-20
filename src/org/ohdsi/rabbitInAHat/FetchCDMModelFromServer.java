/*******************************************************************************
 * Copyright 2014 Observational Health Data Sciences and Informatics
 * 
 * This file is part of WhiteRabbit
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author Observational Health Data Sciences and Informatics
 * @author Martijn Schuemie
 ******************************************************************************/
package org.ohdsi.rabbitInAHat;

import org.ohdsi.databases.DbType;
import org.ohdsi.databases.RichConnection;
import org.ohdsi.utilities.files.Row;
import org.ohdsi.utilities.files.WriteCSVFileWithHeader;

public class FetchCDMModelFromServer {
	
	public static void main(String[] args) {
		RichConnection connection = new RichConnection("127.0.0.1", null, "root", "F1r3starter", DbType.MYSQL);
		connection.use("cdm_v4");
		
		WriteCSVFileWithHeader out = new WriteCSVFileWithHeader("c:/temp/CDMV4Model.csv");
		String query = "SELECT table_name,column_name,is_nullable,column_type FROM information_schema.columns WHERE table_schema = 'cdm_v4';";
		for (Row row : connection.query(query))
			out.write(row);
		out.close();
		
	}
	
}
