package com.habuma.santaslist.child;

import java.util.List;

public interface ChildRepository {
	
	long createChild(Child child);
	
	Child getChild(long id);
	
	List<Child> getAllChildren();
	
	void updateStatus(long id, boolean naughty);

}
