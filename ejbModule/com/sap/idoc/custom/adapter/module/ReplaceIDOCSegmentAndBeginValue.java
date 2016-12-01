package com.sap.idoc.custom.adapter.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;

public class ReplaceIDOCSegmentAndBeginValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute(InputStream input, OutputStream output, String[] search)
			throws ReplaceIDOCSegementAndBeginValueException {
		try {
			String idoc = getStringFromInputStream(input, search);
			output.write(idoc.getBytes());
		} catch (IOException e) {
			throw new ReplaceIDOCSegementAndBeginValueException(e.getMessage());
		}

	}

	// convert InputStream to String
	private String getStringFromInputStream(InputStream is, String[] search)
			throws ReplaceIDOCSegementAndBeginValueException {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				String replaceLine = line;
				for (int i = 0; i < search.length; i++) {
					if (search[i].contains("SEGMENT")) {
						replaceLine = replaceLine.replaceAll(search[i], "SEGMENT=\"1\"");
					}
					if (search[i].contains("BEGIN")) {
						replaceLine = replaceLine.replaceAll(search[i], "BEGIN=\"1\"");
					}
				}
				
				sb.append(replaceLine);
			}

		} catch (IOException e) {
			throw new ReplaceIDOCSegementAndBeginValueException(e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new ReplaceIDOCSegementAndBeginValueException(e.getMessage());
				}
			}
		}

		return sb.toString();

	}

}
