package com.rootser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NameGeneratorImpl implements NameGenerator{
	List<String> names = new ArrayList<String>();
	@Autowired
	Scanner scanner;
	@Autowired
	Random randy;
	public String getNextName() {
		if (names.size() == 0){
			while (scanner.hasNextLine()){
				names.add(scanner.nextLine());
			}
		}
		return names.get(randy.nextInt(names.size()));
	}

}
