package com.readComics.bpo.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.readComics.bpo.model.Chapter;

@Component
public class FileService {

	public List<String> readFile(Chapter chapter) throws Exception {
		File file = new File(
				"/bpo/src/main/resources/contentComic/" + chapter.getProduct().getNameProduct() + chapter.getId());
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		List<String> listContent = new ArrayList<>();

		BufferedReader bufferReader = null;

		String line = null;

		try {
			FileReader inputStream = new FileReader(file);
			bufferReader = new BufferedReader(inputStream);

			while ((line = bufferReader.readLine()) != null) {

				listContent.add(line);

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			bufferReader.close();

		}

		return listContent;
	}

	public boolean writeFile(Chapter chapter) {

		try {
			FileWriter fileWriter = new FileWriter(
					"/bpo/src/main/resources/contentComic/" + chapter.getProduct().getNameProduct() + chapter.getId(),
					true);

			BufferedWriter buffereWriter = new BufferedWriter(fileWriter);

			buffereWriter.write(chapter.getContent());
			buffereWriter.newLine();

			buffereWriter.close();
		} catch (IOException e) {

			e.printStackTrace();

			return false;
		}

		return true;
	}

}
