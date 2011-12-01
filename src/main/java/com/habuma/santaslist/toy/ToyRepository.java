package com.habuma.santaslist.toy;

import java.util.List;

public interface ToyRepository {
	
	long createToy(Toy toy);
	
	Toy getToy(long id);
	
	List<Toy> getAllToys();
	
	void updateOnHand(long id, long onhand);
	
	void deleteToy(long id);

}
