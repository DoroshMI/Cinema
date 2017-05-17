package ua.lviv.cinema.swing;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.Label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Date;
import java.util.Iterator;

import java.util.List;
import java.util.Map;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ua.lviv.cinema.dao.CinemaDao;
import ua.lviv.cinema.dao.UserDao;
import ua.lviv.cinema.dao.MovieDao;
import ua.lviv.cinema.dao.MoviehallDao;
import ua.lviv.cinema.dao.ScheduleDao;
import ua.lviv.cinema.dao.SeanceDao;

import ua.lviv.cinema.entity.Cinema;
import ua.lviv.cinema.entity.Coordinate;
import ua.lviv.cinema.entity.Movie;
import ua.lviv.cinema.entity.Moviehall;
import ua.lviv.cinema.entity.Schedule;
import ua.lviv.cinema.entity.Seance;
import ua.lviv.cinema.entity.Seat;
import ua.lviv.cinema.service.CinemaService;
import ua.lviv.cinema.service.MovieService;
import ua.lviv.cinema.service.MoviehallService;
import ua.lviv.cinema.service.ScheduleService;
import ua.lviv.cinema.service.SeanceService;
import ua.lviv.cinema.service.SeatService;
import ua.lviv.cinema.service.UserService;

public class MainForm {

	 static Cinema cinema = new FunctionalityForm().init();

	//static Cinema cinema = new FunctionalityForm().read();

	static ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	private static CinemaService cinemaService = context.getBean("cinemaServiceImpl", CinemaService.class);
	private static UserService userService = (UserService) context.getBean("userServiceImpl");
	private static MoviehallService moviehallService = (MoviehallService) context.getBean("moviehallServiceImpl");
	private static ScheduleService scheduleService = (ScheduleService) context.getBean("scheduleServiceImpl");
	private static SeanceService seanceService = (SeanceService) context.getBean("seanceServiceImpl");
	private static MovieService movieService = (MovieService) context.getBean("movieServiceImpl");
	private static SeatService seatService = context.getBean("seatServiceImpl", SeatService.class);

	static JPanel panelNORTH = new JPanel();

	static JPanel panelCENTER = new JPanel();
	static JPanel panelCenterTopButton = new JPanel();
	static JPanel panelCenterTopAdministration = new JPanel();

	static JPanel panelSOUTH = new JPanel();
	static JPanel panelWEST = new JPanel();
	static JPanel panelEAST = new JPanel();

	static JTextArea textArea;
	static JTextArea textAreaMessages;
	static JTextArea textAreaAllMovies;

	static JComboBox<String> comboBoxHall;

	static JScrollPane scrollPane;

	static JPanel panelRadioButton = new JPanel();
	static ButtonGroup group = new ButtonGroup();
	static JButton buttonSave = new JButton("Save");
	static JButton buttonDownload = new JButton("Download");

	static JButton buttonScheduleToday = new JButton("Today");
	static JButton buttonScheduleTomorrow = new JButton("Tomorrow");
	static JButton buttonScheduleWeek = new JButton("Week");
	static JButton buttonShowMovie = new JButton("Show movie");
	static JTextField textFieldNumberMovie = new JTextField(10);
	static Box boxCenterTopSchedule;
	static Box boxCenterTopFilms;
	static Box boxCenterTopTicket;

	static Box boxBuyTicket = Box.createHorizontalBox();
	static Box boxBuyTicketData = Box.createVerticalBox();
	static JTextArea textAreaSceameSeats = new JTextArea(30, 50);
	static JTextField textFieldTicketRow = new JTextField(5);
	static JTextField textFieldTicketColumn = new JTextField(5);

	static JTextArea textAreaMessageTickets = new JTextArea(15, 50);

	static JTextField textFieldTicketDay = new JTextField("2017-05-13", 10);
	static JTextField textFieldTicketHall = new JTextField("hall1", 10);
	static JTextField textFieldTicketTime = new JTextField("11:0", 10);

	static JTextField textFieldTime;
	static JTextField textFieldNumberMovieAdmin = new JTextField("2", 10);;

	static JCheckBox checkBoxDay0;
	static JCheckBox checkBoxDay1;
	static JCheckBox checkBoxDay2;
	static JCheckBox checkBoxDay3;
	static JCheckBox checkBoxDay4;
	static JCheckBox checkBoxDay5;
	static JCheckBox checkBoxDay6;

	private static LocalDate[] days = FunctionalityForm.allDays();

	//private static List<Coordinate> ñoordinates = new ArrayList<>();
	private static List<Seat> seats = new ArrayList<>();
	private static Seance seanceBuy;

	// static JButton button;

	public static void main(String[] args) {

		// ConfigurableApplicationContext context = new
		// ClassPathXmlApplicationContext("applicationContext.xml");
		//
		// cinemaService = context.getBean("cinemaServiceImpl",
		// CinemaService.class);

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1300, 700);
				frame.setVisible(true);
				frame.setTitle("Cinema");

				frame.add(panelNORTH, BorderLayout.NORTH);
				frame.add(panelCENTER, BorderLayout.CENTER);
				frame.add(panelSOUTH, BorderLayout.SOUTH);
				frame.add(panelWEST, BorderLayout.WEST);
				frame.add(panelEAST, BorderLayout.EAST);

				// ------------------NORTH----------------------------------------
				panelNORTH.setLayout(new GridLayout(2, 1));

				panelNORTH.add(new JLabel("IMAGE"));

				Box boxTopMenu = Box.createHorizontalBox();
				boxTopMenu.add(buttonSave);
				buttonSave.addActionListener(new SaveActionListener());
				boxTopMenu.add(buttonDownload);
				buttonDownload.addActionListener(new DownloadActionListener());

				JRadioButton schedule = new JRadioButton("schedule", true);
				group.add(schedule);
				schedule.addActionListener(new RadioButtonScheduleActionListener());

				JRadioButton filems = new JRadioButton("films", false);
				group.add(filems);
				filems.addActionListener(new RadioButtonFilmsActionListener());

				JRadioButton administration = new JRadioButton("administration", false);
				administration.addActionListener(new RadioButtonAdministrationActionListener());
				group.add(administration);

				panelRadioButton.add(schedule);
				panelRadioButton.add(filems);
				panelRadioButton.add(administration);

				boxTopMenu.add(panelRadioButton);

				panelNORTH.add(boxTopMenu);

				// ------------------CENTER---------------------------------------

				panelSOUTH.setVisible(false);
				panelWEST.setVisible(false);

				boxCenterTopSchedule = Box.createHorizontalBox();
				boxCenterTopFilms = Box.createHorizontalBox();
				boxCenterTopFilms.setVisible(false);
				boxCenterTopTicket = Box.createHorizontalBox();

				boxCenterTopSchedule.add(buttonScheduleToday);
				buttonScheduleToday.addActionListener(new ScheduleDayActionListener(LocalDate.now()));
				boxCenterTopSchedule.add(buttonScheduleTomorrow);
				buttonScheduleTomorrow
						.addActionListener(new ScheduleDayActionListener(LocalDate.of(LocalDate.now().getYear(),
								LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth() + 1)));

				boxCenterTopSchedule.add(buttonScheduleWeek);
				buttonScheduleWeek.addActionListener(new ScheduleWeekActionListener());

				boxCenterTopFilms.add(textFieldNumberMovie);

				boxCenterTopFilms.add(buttonShowMovie);
				buttonShowMovie.addActionListener(new ShowMovieActionListener());

				panelCENTER.setLayout(new GridBagLayout());

				GridBagConstraints constraints = new GridBagConstraints();

				constraints.fill = GridBagConstraints.SOUTHWEST;

				boxCenterTopTicket.add(Box.createHorizontalStrut(50));
				boxCenterTopTicket.add(new Label("Day"));
				boxCenterTopTicket.add(textFieldTicketDay);
				textFieldTicketDay.setText(days[0].getDayOfWeek().name());
				boxCenterTopTicket.add(Box.createHorizontalStrut(15));
				boxCenterTopTicket.add(new Label("Hall"));
				boxCenterTopTicket.add(textFieldTicketHall);
				boxCenterTopTicket.add(Box.createHorizontalStrut(15));
				boxCenterTopTicket.add(new Label("Time"));
				boxCenterTopTicket.add(textFieldTicketTime);
				boxCenterTopTicket.add(Box.createHorizontalStrut(25));
				JButton buttonTicket = new JButton("ticket");
				buttonTicket.addActionListener(new ShowTicketActionListener());
				boxCenterTopTicket.add(buttonTicket);
				panelCENTER.add(boxCenterTopSchedule, constraints);
				panelCENTER.add(boxCenterTopFilms, constraints);
				panelCENTER.add(boxCenterTopTicket, constraints);

				Box boxDays = Box.createVerticalBox();

				checkBoxDay0 = new JCheckBox(days[0].getDayOfWeek().name());
				checkBoxDay1 = new JCheckBox(days[1].getDayOfWeek().name());

				checkBoxDay2 = new JCheckBox(days[2].getDayOfWeek().name());
				checkBoxDay3 = new JCheckBox(days[3].getDayOfWeek().name());
				checkBoxDay4 = new JCheckBox(days[4].getDayOfWeek().name());
				checkBoxDay5 = new JCheckBox(days[5].getDayOfWeek().name());
				checkBoxDay6 = new JCheckBox(days[6].getDayOfWeek().name());
				boxDays.add(checkBoxDay0);
				boxDays.add(checkBoxDay1);
				boxDays.add(checkBoxDay2);
				boxDays.add(checkBoxDay3);
				boxDays.add(checkBoxDay4);
				boxDays.add(checkBoxDay5);
				boxDays.add(checkBoxDay6);
				panelCenterTopAdministration.add(boxDays);

				Box boxData = Box.createVerticalBox();

				Box boxNumberMovie = Box.createHorizontalBox();
				JLabel labelNumberMovie = new JLabel("number movie");

				boxNumberMovie.add(labelNumberMovie);
				boxNumberMovie.add(Box.createHorizontalStrut(10));
				boxNumberMovie.add(textFieldNumberMovieAdmin);
				boxData.add(boxNumberMovie);
				boxData.add(Box.createVerticalStrut(20));

				Box boxHall = Box.createHorizontalBox();
				JLabel labelHall = new JLabel("name hall");

				comboBoxHall = new JComboBox<>();
				cinema = cinemaService.findByIdWithMoviehalls(cinema);
				for (Moviehall hall : cinema.getMoviehalls()) {
					comboBoxHall.addItem(hall.getName());
				}

				boxHall.add(labelHall);
				boxHall.add(Box.createHorizontalStrut(10));
				boxHall.add(comboBoxHall);
				boxData.add(boxHall);
				boxData.add(Box.createVerticalStrut(20));

				Box boxTime = Box.createHorizontalBox();
				JLabel labelTime = new JLabel("time");
				textFieldTime = new JTextField("9:00; 12:00");
				boxTime.add(labelTime);
				boxTime.add(Box.createHorizontalStrut(10));
				boxTime.add(textFieldTime);
				boxData.add(boxTime);

				JLabel labelExempleTime1 = new JLabel("for example: 10:30");
				JLabel labelExempleTime3 = new JLabel("or 10:30; 12:00; 13:40");

				boxData.add(labelExempleTime1);
	
				boxData.add(labelExempleTime3);
				boxData.add(Box.createVerticalStrut(20));

				Box boxAction = Box.createHorizontalBox();
				JButton buttonAddMovies = new JButton("add movies");
				buttonAddMovies.addActionListener(new AdministrationAddMoviesActionListener());
				JButton buttonRemoveMovies = new JButton("remove movies");
				buttonRemoveMovies.addActionListener(new AdministrationRemoveMoviesActionListener());
				boxAction.add(buttonAddMovies);
				boxAction.add(Box.createHorizontalStrut(20));
				boxAction.add(buttonRemoveMovies);
				boxData.add(boxAction);

				panelCenterTopAdministration.add(boxData);

				textAreaAllMovies = new JTextArea(15, 30);
				JScrollPane scrollPaneAllMovies = new JScrollPane(textAreaAllMovies);
				panelCenterTopAdministration.add(scrollPaneAllMovies);
				textAreaMessages = new JTextArea(15, 30);
				JScrollPane scrollPaneMessages = new JScrollPane(textAreaMessages);
				panelCenterTopAdministration.add(scrollPaneMessages);

				panelCenterTopAdministration.setVisible(false);
				panelCENTER.add(panelCenterTopAdministration, constraints);

				textArea = new JTextArea(30, 105);
				scrollPane = new JScrollPane(textArea);
				constraints.fill = GridBagConstraints.NORTH;
				constraints.ipady = 45; // êíîïêà âûñîêàÿ
				constraints.weightx = 0.0;
				constraints.gridwidth = 5; // ðàçìåð êíîïêè â äâå ÿ÷åéêè
				constraints.gridx = 0; // íóëåâàÿ ÿ÷åéêà ïî ãîðèçîíòàëè
				constraints.gridy = 1; // ïåðâàÿ ÿ÷åéêà ïî âåðòèêàëè

				panelCENTER.add(scrollPane, constraints);

				boxBuyTicket.add(textAreaSceameSeats);
				boxBuyTicket.add(Box.createHorizontalStrut(20));

				boxBuyTicketData.add(new Label("row: "));
				boxBuyTicketData.add(textFieldTicketRow);
				boxBuyTicketData.add(new Label("column: "));
				boxBuyTicketData.add(textFieldTicketColumn);

				boxBuyTicketData.add(Box.createHorizontalStrut(20));
				JButton buttonReserveTicket = new JButton("reserve");
				boxBuyTicketData.add(buttonReserveTicket);
				buttonReserveTicket.addActionListener(new ReserveTicketActionListener());
				boxBuyTicketData.add(Box.createVerticalStrut(20));
				boxBuyTicketData.add(textAreaMessageTickets);
				boxBuyTicketData.add(Box.createVerticalStrut(20));
				JButton buttonBuyTicket = new JButton("buy");
				boxBuyTicketData.add(buttonBuyTicket);
				buttonBuyTicket.addActionListener(new BuyTicketActionListener());
				boxBuyTicket.add(boxBuyTicketData);

				panelCENTER.add(boxBuyTicket, constraints);
				// boxBuyTicket.setVisible(false);

				// ------------------SOUNTH---------------------------------------

				// ------------------WEST-----------------------------------------
				panelWEST.setLayout(new GridLayout(7, 1));

				panelWEST.setVisible(false);

				JButton buttonAdministrationDay0 = new JButton(days[0].getDayOfWeek().name());
				buttonAdministrationDay0.addActionListener(new AdministrationDayActionListener(days[0]));
				JButton buttonAdministrationDay1 = new JButton(days[1].getDayOfWeek().name());
				buttonAdministrationDay1.addActionListener(new AdministrationDayActionListener(days[1]));
				JButton buttonAdministrationDay2 = new JButton(days[2].getDayOfWeek().name());
				buttonAdministrationDay2.addActionListener(new AdministrationDayActionListener(days[2]));
				JButton buttonAdministrationDay3 = new JButton(days[3].getDayOfWeek().name());
				buttonAdministrationDay3.addActionListener(new AdministrationDayActionListener(days[3]));
				JButton buttonAdministrationDay4 = new JButton(days[4].getDayOfWeek().name());
				buttonAdministrationDay4.addActionListener(new AdministrationDayActionListener(days[4]));
				JButton buttonAdministrationDay5 = new JButton(days[5].getDayOfWeek().name());
				buttonAdministrationDay5.addActionListener(new AdministrationDayActionListener(days[5]));
				JButton buttonAdministrationDay6 = new JButton(days[6].getDayOfWeek().name());
				buttonAdministrationDay6.addActionListener(new AdministrationDayActionListener(days[6]));

				panelWEST.add(buttonAdministrationDay0);
				panelWEST.add(buttonAdministrationDay1);
				panelWEST.add(buttonAdministrationDay2);
				panelWEST.add(buttonAdministrationDay3);
				panelWEST.add(buttonAdministrationDay4);
				panelWEST.add(buttonAdministrationDay5);
				panelWEST.add(buttonAdministrationDay6);

				// ------------------EAST-----------------------------------------

			}

		});
	}

	private static class RadioButtonScheduleActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panelSOUTH.setVisible(false);
			panelWEST.setVisible(false);

			boxCenterTopSchedule.setVisible(true);
			boxCenterTopFilms.setVisible(false);
			boxCenterTopTicket.setVisible(true);

			panelCenterTopAdministration.setVisible(false);
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);
			textArea.setRows(30);

			panelCENTER.revalidate();
			new ScheduleDayActionListener(LocalDate.now()).actionPerformed(arg0);
		}

	}

	private static class ScheduleDayActionListener implements ActionListener {

		LocalDate day;

		public ScheduleDayActionListener(LocalDate day) {
			this.day = day;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			panelCenterTopAdministration.setVisible(false);
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);
			textArea.setRows(30);

			textArea.setText(Output.printTopHours());
			textFieldTicketDay.setText(day.getDayOfWeek().name());
			textArea.append(Output.printScheduleOfDay(seanceService.allSeancesOfDay(cinema, day)));
		}
	}

	private static class ScheduleWeekActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			panelCenterTopAdministration.setVisible(false);
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);
			textArea.setRows(30);

			textArea.setText(Output.printTopHours());
			textFieldTicketDay.setText("");
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < 75; i++)
				stringBuilder.append("=");

			for (int i = 0; i < 7; i++) {

				textArea.append(stringBuilder + days[i].getDayOfWeek().name() + stringBuilder + "\n");
				textArea.append(
						Output.printScheduleOfDay(seanceService.allSeancesOfDay(cinema, LocalDate.of(LocalDate.now().getYear(),
								LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth() + i))));

			}
		}
	}

	private static class RadioButtonFilmsActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			panelSOUTH.setVisible(false);
			panelWEST.setVisible(false);

			boxCenterTopSchedule.setVisible(false);
			boxCenterTopFilms.setVisible(true);
			boxCenterTopTicket.setVisible(true);

			panelCenterTopAdministration.setVisible(false);
			textArea.setText("");
			textFieldTicketDay.setText("");
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);
			panelCENTER.revalidate();

			// Map<Movie, Map<Day, Set<Seance>>> movies =
			// movieDao.allMoviesOfWeek();
			List<Movie> movies = movieService.findAll();
			int numberMovie = 1;

			boolean textSoon = false;

			if (movies.size() == 0) {
				textArea.append("no films on show");
				return;
			}

			if (movies.get(0).getReleaseDateFrom().compareTo(LocalDate.now()) <= 0) {
				textArea.append("Ô²ËÜÌÈ Â ÏÎÊÀÇ²:\n");
			} else {
				textArea.append("SOON ON SCREAN:\n");
				textSoon = true;
			}

			StringBuilder topLine = new StringBuilder();
			for (int i = 0; i < 280; i++)
				topLine.append("-");

			for (Movie movie : movies) {
				if (movie.getReleaseDateFrom().compareTo(LocalDate.now()) > 0 && !textSoon) {
					textArea.append(topLine.toString() + "\nSOON ON SCREAN:\n");
					textSoon = true;
				}
				textArea.append("    " + numberMovie++ + ". " + movie.getTitle() + "\n\n"); // name
																							// movi
			}
		}
	}

	private static class ShowMovieActionListener implements ActionListener {

		private int numberMovie;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
//			textFieldTicketDay = new JTextField("2017-05-13", 10);
//			textFieldTicketHall = new JTextField("hall1", 10);
//			textFieldTicketTime = new JTextField("11:0", 10);


			panelCenterTopAdministration.setVisible(false);
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);
			textArea.setRows(30);

			this.numberMovie = Integer.valueOf(textFieldNumberMovie.getText().trim());

			// ÏÎÜÐ²ÁÍÎ ÊÈÍÓÒÈ ÏÎÌÈËÊÓ êîëè ÷èñëî á³ëüøå â³ä ìàñèâó
			Movie movie = movieService.findAll().get(numberMovie - 1);

			List<Seance> moviesOfMovie = seanceService.allSeancesOfMovie(cinema, movie);

			textArea.setText(Output.printTopHours());

			textArea.append(Output.printScheduleOfMovie(moviesOfMovie));

			//

		}

	}

	private static class RadioButtonAdministrationActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			panelSOUTH.setVisible(true);
			panelWEST.setVisible(true);

			boxCenterTopSchedule.setVisible(false);
			boxCenterTopFilms.setVisible(false);
			boxCenterTopTicket.setVisible(false);

			panelCenterTopAdministration.setVisible(true);

			textArea.setRows(15);
			boxBuyTicket.setVisible(false);
			scrollPane.setVisible(true);

			panelCENTER.revalidate();
			panelWEST.revalidate();

			textArea.setText("Choose day for administration");
			textAreaAllMovies.setText("");
			textAreaMessages.setText("");

			int numberMovie = 1;
			textAreaAllMovies.append("List of movies:\n");
			
			cinema = cinemaService.findByIdWithMovies(cinema);
			for (Movie movie : cinema.getMovies()) {
				textAreaAllMovies.append("    " + numberMovie++ + ". " + movie + "\n\n"); // name
																							// movie
			}

		}

	}

	private static class AdministrationDayActionListener implements ActionListener {

		private LocalDate day;

		public AdministrationDayActionListener(LocalDate day) {
			this.day = day;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			textArea.setText(String.format("%180s", day.getDayOfWeek().name()) + "\n");
			textArea.append(Output.printTopHours());

			cinema = cinemaService.findByIdWithMoviehalls(cinema);
			
			textArea.append(Output.printScheduleOfHalls(seanceService.allSeancesOfDay(cinema, day), cinema));

		}

	}

	private static class AdministrationAddMoviesActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Moviehall moviehall = cinema.getMoviehalls().stream()
					.filter(mh -> mh.getName().equalsIgnoreCase((String) comboBoxHall.getSelectedItem())).findFirst()
					.get();

			Schedule schedule = null;

			Movie movie = cinema.getMovies().toArray(
					new Movie[cinema.getMovies().size()])[Integer.valueOf(textFieldNumberMovieAdmin.getText()) - 1];

			String line = textFieldTime.getText().replaceAll(" ", "").replaceAll(";", ":").replace("...", ":");

			String[] stringTimes = line.split(":");

			JCheckBox[] checkBoxDays = { checkBoxDay0, checkBoxDay1, checkBoxDay2, checkBoxDay3, checkBoxDay4,
					checkBoxDay5, checkBoxDay6 };

			for (int j = 0; j < 7; j++) {
				// Day day = Day.values()[(j + new Date().getDay()) % 7];
				LocalDate day = days[j];

				if (checkBoxDays[j].isSelected()) {
					schedule = scheduleService.findByDateAndMoviehall(day, moviehall);

					if (textFieldTime.getText().contains("...")) {
						// LocalDateTime startTime = LocalDateTime.of(day,
						// LocalTime.of(Integer.valueOf(stringTimes[0]),
						// Integer.valueOf(stringTimes[1])));
						// LocalDateTime endTime = LocalDateTime.of(day,
						// LocalTime.of(Integer.valueOf(stringTimes[2]),
						// Integer.valueOf(stringTimes[3])));
						//
						//
						// seanceService.saveSeancesOverPeriod(movie, startTime,
						// endTime, schedule, 77);

					} else {
						List<LocalDateTime> times = new ArrayList<>();

						for (int k = 0; k < stringTimes.length; k++) {
							times.add(LocalDateTime.of(day,
									LocalTime.of(Integer.valueOf(stringTimes[k++]), Integer.valueOf(stringTimes[k]))));
						}

						seanceService.saveAllSeances(movie, times, schedule, 100);

					}
					new AdministrationDayActionListener(day).actionPerformed(arg0);
				}
			}

		}

	}

	private static class AdministrationRemoveMoviesActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Moviehall moviehall = cinema.getMoviehalls().stream()
			.filter(mh -> mh.getName().equalsIgnoreCase((String) comboBoxHall.getSelectedItem())).findFirst()
			.get();
			
			Movie movie = cinema.getMovies().toArray(
					new Movie[cinema.getMovies().size()])[Integer.valueOf(textFieldNumberMovieAdmin.getText()) - 1];

			String line = textFieldTime.getText().replaceAll(" ", "").replaceAll(";", ":");
			String[] stringTimes = line.trim().split(":");

			JCheckBox[] checkBoxDays = { checkBoxDay0, checkBoxDay1, checkBoxDay2, checkBoxDay3, checkBoxDay4,
					checkBoxDay5, checkBoxDay6 };

			for (int i = 0; i < 7; i++) {
				LocalDate day = days[i];

				if (checkBoxDays[i].isSelected()) {

					if (textFieldTime.getText().contains("...")) {

//						Time startTime = new Time(Integer.valueOf(stringTimes[0]), Integer.valueOf(stringTimes[1]));
//						Time endTime = new Time(Integer.valueOf(stringTimes[2]), Integer.valueOf(stringTimes[3]));
//
//						movieHall.removeAllMovies(day, movie, startTime, endTime);

					} else {

						List<LocalDateTime> times = new ArrayList<>();
						List<Seance> seances = new ArrayList<>();

						for (int j = 0; j < stringTimes.length; j++) {
//							times.add(LocalDateTime.of(day,
//									LocalTime.of(Integer.valueOf(stringTimes[j++]), Integer.valueOf(stringTimes[j]))));
							LocalDateTime time = LocalDateTime.of(day,
									LocalTime.of(Integer.valueOf(stringTimes[j++]), Integer.valueOf(stringTimes[j])));
							
							moviehall = moviehallService.findByIdWithSchedules(moviehall.getId());
							
							Schedule schedule = moviehall.getSchedules().stream()
									.filter(s -> s.getDate().equals(day)).findFirst().get();
							
							schedule = scheduleService.findByIdWithSeances(schedule.getId());
							seances.add(
									schedule.getSeances()
									.stream().filter(seance -> seance.getStartTime().equals(time)).findFirst().get());
							
						}
						//seanceService.deleteAllSeances(movie, times, moviehall);
						seanceService.deleteAllSeances(seances);
					}
					new AdministrationDayActionListener(day).actionPerformed(arg0);
				}
			}

		}

	}

	private static class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// new CimemaDAO("cinema").writeObject(cinema);

		}

	}

	private static class DownloadActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// cinema = new CimemaDAO("cinema").readObject();

		}

	}

	private static class ShowTicketActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			boxBuyTicket.setVisible(true);
			scrollPane.setVisible(false);
			//ñoordinates.clear();
			seats.clear();

			textAreaSceameSeats.setText("");
			textAreaMessageTickets.setText("");
			
			
		
			LocalDate date = LocalDate.of(Integer.valueOf(textFieldTicketDay.getText().split("-")[0]),
					Integer.valueOf(textFieldTicketDay.getText().split("-")[1]),
					Integer.valueOf(textFieldTicketDay.getText().split("-")[2]));

			LocalDateTime time = LocalDateTime.of(date, LocalTime.of(Integer.valueOf(textFieldTicketTime.getText().split(":")[0]),
					Integer.valueOf(textFieldTicketTime.getText().split(":")[1])));
			
			seanceBuy = seanceService.findByMoviehallAndTime(cinema.getMoviehalls().stream()
					.filter(moviehall -> moviehall.getName().equalsIgnoreCase(textFieldTicketHall.getText())).findFirst().get(), time);
			
			System.out.println(time);
			System.out.println(textFieldTicketHall.getText());

			seanceBuy = seanceService.findByIdWithSeats(seanceBuy.getId());

			textAreaSceameSeats.append(Output.printSeats(seanceBuy));
			textAreaMessageTickets.append("Day: " + textFieldTicketDay.getText() + "\n Movie: "
					+ seanceBuy.getMovie().getTitle() + "\n time: " + seanceBuy.getStartTime());

			panelCENTER.revalidate();

		}
	}

	private static class ReserveTicketActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Coordinate coordinate = new Coordinate(Integer.valueOf(textFieldTicketRow.getText()) - 1,
					Integer.valueOf(textFieldTicketColumn.getText()) - 1);
			
			Seat seat = seanceBuy.getSeat(coordinate);
			
			
			if (seats.contains(seat) || !seat.isFreeSeat()) {
					return;
				}
			seats.add(seat);
			//ñoordinates.add(coordinate);

			textAreaMessageTickets.setText("");
			textAreaMessageTickets.append("Day: " + textFieldTicketDay.getText() + "\n Movie: "
					+ seanceBuy.getMovie().getTitle() + "\n time: " + seanceBuy.getStartTime() + "\n\n");
			textAreaMessageTickets.append(seats.size() + " tickets\n");
			int totalPrice = 0;
			for (Seat s : seats) {

				
					textAreaMessageTickets
							.append("row: " + (s.getÑoordinate().getRow() + 1) + " column: " + (s.getÑoordinate().getColumn() + 1)
									+ " price: " + seanceBuy.getSeat(s.getÑoordinate()).getPrice() + "\n");
				
				
					totalPrice += seanceBuy.getSeat(s.getÑoordinate()).getPrice();
				
			}

			textAreaMessageTickets.append("\nTotal price: " + totalPrice);

		}

	}

	private static class BuyTicketActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			seats.stream().forEach(seat -> {				
					seat.setFreeSeat(false);
					seat.setReservedSeat(false);
					cinema.setMoney(cinema.getMoney() + (double)seat.getPrice());					
					seatService.update(seat);			
			});
			
			cinemaService.update(cinema);
			
			
			textAreaSceameSeats.setText("");
			textAreaSceameSeats.append(Output.printSeats(seanceBuy));
			textAreaMessageTickets.setText("");
			textAreaMessageTickets.append("Day: " + textFieldTicketDay.getText() + "\n Movie: "
					+ seanceBuy.getMovie().getTitle() + "\n time: " + seanceBuy.getStartTime());
			seats.clear();
		}

	}

}
