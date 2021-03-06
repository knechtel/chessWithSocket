
package br.com.chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import br.com.chess.bean.Bishop;
import br.com.chess.bean.Horse;
import br.com.chess.bean.King;
import br.com.chess.bean.Pawn;
import br.com.chess.bean.Piece;
import br.com.chess.bean.Queen;
import br.com.chess.bean.Square;
import br.com.chess.bean.Tower;
import br.com.chess.client.Client;



public class Main extends JPanel {
	/**
	 * @author Maiquel knechtel
	 */
	private static final long serialVersionUID = 1;

	private Client client;
	private Piece[][] chessboard;
	private List<Square> listSquare;
	private boolean playerOne;

	public Main(Client client) {
		this.setClient(client);
		playerOne = client.isPlayerOne();
		chessboard = new Piece[8][8];
		Session.setPlayerOne(playerOne);
		Session.setCheessBoard(chessboard);
		
		if (playerOne) {
			Config.doConfigPlayerOne();
		} else {
			Config.doConfigPlayerTwo();
		}

	}
	
	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		listSquare = new ArrayList<Square>();
		int x = 0, y = 0;
		boolean ctl = true;
		for (int j = 0; j <= 7; j++) {
			x = 0;
			for (int i = 0; i <= 7; i++) {
				ctl = !ctl;
				if (ctl) {
					g2.setPaint(Color.gray);
					g2.fill(new Rectangle2D.Double(x, y, 50, 50));
					listSquare.add(new Square(x, y, Color.gray));
				} else {
					g2.setPaint(Color.white);
					g2.fill(new Rectangle2D.Double(x, y, 50, 50));
					listSquare.add(new Square(x, y, Color.white));
				}
				x += 50;
			}
			ctl = !ctl;
			y += 50;
		}
		
		if (playerOne) {
			fillChessbordBlack(g2);
		} else {
			fillChessbordWhite(g2);
		}

	}

	public void fillChessbordBlack(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage imgPawnWhite = null;
		BufferedImage imgHorseWhite = null;
		BufferedImage imgBishopWhite = null;
		BufferedImage imgTowerWhite = null;
		BufferedImage imgQueenWhite = null;
		BufferedImage imgKingWhite = null;

		BufferedImage imgPawnBlack = null;
		BufferedImage imgHorseBlack = null;
		BufferedImage imgBishopBlack = null;
		BufferedImage imgTowerBlack = null;
		BufferedImage imgQueenBlack = null;
		BufferedImage imgKingBlack = null;

		try {
			imgTowerWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerWhite.png"));
			imgPawnWhite = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "pawnWhite.png"));
			imgHorseWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "horseWhite.png"));
			imgBishopWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "bishopWhite.png"));
			imgTowerWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerWhite.png"));
			imgQueenWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "QueenWhite.png"));
			imgKingWhite = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "kingWhite.png"));
			// Black
			imgPawnBlack = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "pawnBlack.png"));
			imgHorseBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "horseBlack.png"));
			imgBishopBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "bishopBlack.png"));
			imgTowerBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerBlack.png"));
			imgQueenBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "queenBlack.png"));
			imgKingBlack = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "kingBlack.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				Piece piece = chessboard[i][j];
				if (piece != null) {
					if (piece instanceof Bishop) {
						if (piece.isEnemy()) {
							g.drawImage(imgBishopWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgBishopBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Horse) {
						if (piece.isEnemy()) {
							g.drawImage(imgHorseWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgHorseBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof King) {
						if (piece.isEnemy()) {
							g.drawImage(imgKingWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgKingBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Pawn) {
						if (piece.isEnemy()) {
							g.drawImage(imgPawnWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgPawnBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Queen) {
						if (piece.isEnemy()) {
							g.drawImage(imgQueenWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgQueenBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Tower) {
						if (piece.isEnemy()) {
							g.drawImage(imgTowerWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgTowerBlack, piece.getX(),
									piece.getY(), null);
						}
					}
				}
			}
		}
		g2.dispose();

	}

	public void fillChessbordWhite(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		BufferedImage imgPawnWhite = null;
		BufferedImage imgHorseWhite = null;
		BufferedImage imgBishopWhite = null;
		BufferedImage imgTowerWhite = null;
		BufferedImage imgQueenWhite = null;
		BufferedImage imgKingWhite = null;

		BufferedImage imgPawnBlack = null;
		BufferedImage imgHorseBlack = null;
		BufferedImage imgBishopBlack = null;
		BufferedImage imgTowerBlack = null;
		BufferedImage imgQueenBlack = null;
		BufferedImage imgKingBlack = null;

		try {
			imgTowerWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerWhite.png"));
			imgPawnWhite = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "pawnWhite.png"));
			imgHorseWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "horseWhite.png"));
			imgBishopWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "bishopWhite.png"));
			imgTowerWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerWhite.png"));
			imgQueenWhite = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "QueenWhite.png"));
			imgKingWhite = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "kingWhite.png"));
			// Black
			imgPawnBlack = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "pawnBlack.png"));
			imgHorseBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "horseBlack.png"));
			imgBishopBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "bishopBlack.png"));
			imgTowerBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "towerBlack.png"));
			imgQueenBlack = ImageIO.read(new File(System
					.getProperty("user.dir") + "/img/" + "queenBlack.png"));
			imgKingBlack = ImageIO.read(new File(System.getProperty("user.dir")
					+ "/img/" + "kingBlack.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard.length; j++) {
				Piece piece = chessboard[i][j];
				if (piece != null) {
					if (piece instanceof Bishop) {
						if (!piece.isEnemy()) {
							g.drawImage(imgBishopWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgBishopBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Horse) {
						if (!piece.isEnemy()) {
							g.drawImage(imgHorseWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgHorseBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof King) {
						if (!piece.isEnemy()) {
							g.drawImage(imgKingWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgKingBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Pawn) {
						if (!piece.isEnemy()) {
							g.drawImage(imgPawnWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgPawnBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Queen) {
						if (!piece.isEnemy()) {
							g.drawImage(imgQueenWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgQueenBlack, piece.getX(),
									piece.getY(), null);
						}
					} else if (piece instanceof Tower) {
						if (!piece.isEnemy()) {
							g.drawImage(imgTowerWhite, piece.getX(),
									piece.getY(), null);
						} else {
							g.drawImage(imgTowerBlack, piece.getX(),
									piece.getY(), null);
						}
					}
				}
			}
		}
		g2.dispose();

	}

	public Graphics2D getGraphics2d() {
		return (Graphics2D) getGraphics();
	}

	private static void execute(){
		Client client = new Client();

		JFrame f = null;
		try {
			// espera 2000 milliseconds
			// para dar tempo de definir o player 1
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Main main = new Main(client);
		client.setMain(main);

		if (Session.isPlayerOne()) {
			f = new JFrame("- jogar com as peças pretas -");
			Session.setFrame(f);

		} else {
			f = new JFrame("- Jogar com as Peças Brancas - ");
			Session.setFrame(f);

		}

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});

		f.pack();
		// 440
		f.setSize(new Dimension(406, 428));
		 f.setResizable(false);
		f.setVisible(true);

		f.add(main);
		Handler h = new Handler(main);
		f.addMouseListener(h);

	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public List<Square> getListSquare() {
		return listSquare;
	}

	public void setListSquare(List<Square> listSquare) {
		this.listSquare = listSquare;
	}

	public void setChessboard(Piece[][] chessboard) {
		this.chessboard = chessboard;
	}

	public Piece[][] getChessboard() {
		return chessboard;
	}

	public static void main(String args[]) {
		execute();
	}

	
}
