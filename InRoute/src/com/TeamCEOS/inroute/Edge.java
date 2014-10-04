package com.TeamCEOS.inroute;

public class Edge {

	private final String id; 
	private final Vertex source;
	private final Vertex destination;
	private final int weight; 
	private final int direction;

	public Edge(String id, Vertex source, Vertex destination, int weight, int direction) {
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.direction = direction;
	}

	public String getId() {
		return id;
	}
	public Vertex getDestination() {
		return destination;
	}

	public Vertex getSource() {
		return source;
	}
	public int getWeight() {
		return weight;
	}
	
	public int getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return source + " " + destination;
	}

}
