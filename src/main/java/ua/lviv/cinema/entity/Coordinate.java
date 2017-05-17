package ua.lviv.cinema.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Coordinate {

	@Column(name = "row_")
	private int row = 10; // from 0
	
	@Column(name = "column_")
	private int column = 10; // from 0

	public Coordinate() {
		super();
	}

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "[" + row + ", " + column + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
