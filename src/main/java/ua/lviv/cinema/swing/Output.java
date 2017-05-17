package ua.lviv.cinema.swing;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Seance;

import java.util.Map.Entry;

public class Output {

	private static StringBuilder topLine = new StringBuilder();

	static {
		for (int j = 0; j < 280; j++)
			topLine.append("-");
	}

	/**
	 * 
	 *
	 */
	static String printTopHours() {
		StringBuilder topLineHours = new StringBuilder("                                   ");
		for (int i = 9; i < 27; i++) {
			if (i % 24 <= 9) {
				topLineHours.append("0" + i % 24 + ":00      ");
			} else {
				topLineHours.append(i % 24 + ":00      ");
			}
		}
		String result = topLine.toString() + "\n" + topLineHours.toString() + "\n" + topLine.toString() + "\n";
		return result;
	}

	/**
	 * 
	 *
	 */
	public static String printSeances(Set<Seance> seances) {
		StringBuilder result = new StringBuilder();
		String nameHall = "";
		int cursor = 0;
		for (Seance seance : seances) {
			if (!nameHall.equalsIgnoreCase(seance.getSchedule().getMoviehall().getName())) { // побудова
																								// нового
																								// рядка
				cursor = 0;
				nameHall = seance.getSchedule().getMoviehall().getName();
				result.append("\n");
				String s = String.format("       " + "hall: %-14s", nameHall);
				result.append(s);
			}

			while (cursor < (int) ((seance.getStartTime().getHour() * 60 + seance.getStartTime().getMinute()) - 9 * 60)
					/ 3.70) {// output schedule of time start films
				cursor++;
				result.append(" ");
			}
			
			if(seance.getStartTime().getMinute() != 0){
				result.append(seance.getStartTime().getHour() + ":" + seance.getStartTime().getMinute());
			}else {
				result.append(seance.getStartTime().getHour() + ":" + seance.getStartTime().getMinute() + "0");
			}
			
			cursor += 9;
		}

		result.append("\n");
		result.append(topLine + "\n");

		return result.toString();
	}

	/**
	 * 
	 *
	 */
	static String printScheduleOfDay(List<Seance> allSeancesOfDay) {

		Map<Movie, Set<Seance>> mapAllSeancesOfDay = new TreeMap<>();
		for (Seance seance : allSeancesOfDay) {

			if (!mapAllSeancesOfDay.containsKey(seance.getMovie())) {
				mapAllSeancesOfDay.put(seance.getMovie(), new TreeSet<>(Arrays.asList(seance)));
			} else {
				mapAllSeancesOfDay.get(seance.getMovie()).add(seance);
			}
		}

		int numberFilm = 1;

		StringBuilder result = new StringBuilder();
		for (Entry<Movie, Set<Seance>> entry : mapAllSeancesOfDay.entrySet()) {
			result.append((numberFilm++) + ".   " + entry.getKey().getTitle()); // output
																				// name
																				// movie
			result.append(printSeances(entry.getValue()));
		}
		return result.toString();
	}

	/**
	 * 
	 *
	 */
	static String printScheduleOfMovie(List<Seance> allSeancesOfMovie) {

		Map<LocalDate, Set<Seance>> mapAllSeancesOfMovie = new TreeMap<>();
		for (Seance seance : allSeancesOfMovie) {
			if (!mapAllSeancesOfMovie.containsKey(seance.getSchedule().getDate())) {
				mapAllSeancesOfMovie.put(seance.getSchedule().getDate(), new TreeSet<>(Arrays.asList(seance)));
			} else {
				mapAllSeancesOfMovie.get(seance.getSchedule().getDate()).add(seance);
			}
		}

		StringBuilder result = new StringBuilder();
		for (Entry<LocalDate, Set<Seance>> entry : mapAllSeancesOfMovie.entrySet()) {

			result.append("      " + entry.getKey() + ":"); // output day

			result.append(printSeances(entry.getValue()));

		}

		return result.toString();
	}

	private static String printMovies(Set<Seance> seances) {
		StringBuilder result = new StringBuilder("                                 ");

		int cursor = 0;
		for (Seance seance : seances) {

			while (cursor < (int) ((seance.getStartTime().getHour() * 60 + seance.getStartTime().getMinute()) - 9 * 60)
					/ 3.65) {
				cursor++;
				result.append(" ");
			}
			result.append(seance.getMovie().getTitle());
			cursor += 2.2 * seance.getMovie().getTitle().length();
		}
		return result.toString();
	}

	static String printScheduleOfHalls(List<Seance> allSeancesOfHalls, Cinema cinema) {

		Map<Moviehall, Set<Seance>> mapAllSeancesOfHalls = new TreeMap<>();

		for (Moviehall moviehall : cinema.getMoviehalls()) {

			mapAllSeancesOfHalls.put(moviehall, new TreeSet<>());

		}

		for (Seance seance : allSeancesOfHalls) {

			mapAllSeancesOfHalls.get(seance.getSchedule().getMoviehall()).add(seance);

		}

		StringBuilder result = new StringBuilder();

		for (Entry<Moviehall, Set<Seance>> entry : mapAllSeancesOfHalls.entrySet()) {
			
			if (entry.getValue().size() == 0) {
				result.append(String.format("\n" + "       " + "hall: %-15s", entry.getKey().getName()));
				result.append(printSeances(entry.getValue()));
			} else {

				result.append(printMovies(entry.getValue()) + "\n");
				result.append(printSeances(entry.getValue()));
			}
		}

		return result.toString();
	}

	/**
	 * 
	 *
	 */
	static String printSeats(Seance seance) {
		StringBuilder result = new StringBuilder("Screan \n -----------\n\n" + "    ");

		for (int j = 1; j <= seance.getSchedule().getMoviehall().getColumns(); j++) {
			result.append(j + " ");
		}
		result.append("\n");
		for (int i = 0; i < seance.getSchedule().getMoviehall().getRows(); i++) {
			result.append(i + 1 + "  ");
			for (int j = 0; j < seance.getSchedule().getMoviehall().getColumns(); j++) {

				if (seance.getSeats().get(i * seance.getSchedule().getMoviehall().getColumns() + j).isFreeSeat()) {
					result.append("o ");
				} else {
					result.append("x ");
				}
			}
			result.append("\n");
		}

		return result.toString();
	}

}
