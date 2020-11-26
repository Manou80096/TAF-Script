package com.scripted.testscripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class test {
	public static void main(String[] args) {
		try {
			String command = "dir";
			String s = get_commandline_results(command);
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}

	public static String get_commandline_results(String cmd)
			throws IOException, InterruptedException, IllegalCommandException {

		// Do not remove the authorizedCommand method. Be prepared
		// to lose your hard drive if you have not white-listed the
		// commands that can run.
		if (!authorizedCommand(cmd))
			throw new IllegalCommandException();

		String result = "";
		final Process p = Runtime.getRuntime().exec(String.format("cmd /c %s", cmd));
		final ProcessResultReader stderr = new ProcessResultReader(p.getErrorStream(), "STDERR");
		final ProcessResultReader stdout = new ProcessResultReader(p.getInputStream(), "STDOUT");
		stderr.start();
		stdout.start();
		final int exitValue = p.waitFor();
		if (exitValue == 0) {
			result = stdout.toString();
		} else {
			result = stderr.toString();
		}
		return result;
	}

	public static boolean authorizedCommand(String cmd) {
		// Do not allow any command to be run except for the ones
		// that we have pre-approved here. This lessens the
		// likelihood that fat fingers will wreck your computer.
		if (cmd.equals("dir"))
			return true;
		// add the commands you want to authorize here.

		return false;
	}
}

class ProcessResultReader extends Thread {
	final InputStream is;
	final String type;
	final StringBuilder sb;

	ProcessResultReader(final InputStream is, String type) {
		this.is = is;
		this.type = type;
		this.sb = new StringBuilder();
	}

	public void run() {
		try {
			final InputStreamReader isr = new InputStreamReader(is);
			final BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				this.sb.append(line).append("\n");
			}
		} catch (final IOException ioe) {
			System.err.println(ioe.getMessage());
			throw new RuntimeException(ioe);
		}
	}

	@Override
	public String toString() {
		return this.sb.toString();
	}
}

class IllegalCommandException extends Exception {
	private static final long serialVersionUID = 1L;

	public IllegalCommandException() {
	}
}