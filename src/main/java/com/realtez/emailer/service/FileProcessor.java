package com.realtez.emailer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class FileProcessor {

 
	public void process(String file) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(file));
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> phones = new ArrayList<String>();
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> addresses = new ArrayList<String>();
		ArrayList<String> cities = new ArrayList<String>();
		ArrayList<String> zips = new ArrayList<String>();
		ArrayList<String> areaCodes = new ArrayList<String>();
		while (scan.hasNext()) {
			String curLine = scan.nextLine();
			String[] splitted = curLine.split("\t");
			String licenseType = splitted[0];
			String name = splitted[2].trim();
			String licenseStatus = splitted[4];
			String phone = splitted[10].trim();
			String email = splitted[11].trim();
			String address = splitted[12].trim();

			String city = splitted[15].trim();

			String zip = splitted[17].trim();

			String area = splitted[18].trim();

			String[] prairies = { "Lancaster", "Red Oak", "Ovilla", "Glenn Heights", "Dallas", "Desoto", "Cedar Hill",
					"Duncanville", "Hutchins", "Wilmer" };

			String[] loves = { "Garland", "Mesquite", "Heath", "Murphy", "Wylie", "Rowlett", "Sachse", "Lavon",
					"Forney", "Sunnyvale", "Balch Springs", "lucas", "Dallas" };

			String[] ravenhurst = { "Allen", "Plano", "Frisco", "Richardson", "Parker", "Mckinney" };

			for (String target : ravenhurst) {
			 
				if (licenseType.equalsIgnoreCase("SALE") && licenseStatus.equals("20")
						&& target.equalsIgnoreCase(city)) {

					names.add(name);

					phones.add(phone);

					emails.add(email);

					addresses.add(address);

					cities.add(city);

					zips.add(zip);

 

				}
			}

		}
 
		scan.close();
	}
}
