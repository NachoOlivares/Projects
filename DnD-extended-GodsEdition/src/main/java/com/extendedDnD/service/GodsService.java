package com.extendedDnD.service;

import java.util.List;

import com.extendedDnD.model.God;

public interface GodsService {

	String[] getPantheonContent();

	List<God> getGods();

	String getAppendixContent();

	List<God> getGodsByOrigin(String origin);

	List<God> getGodsByAlignment(String alignment);

	List<God> sortGodsByDeity(boolean asc);

	List<God> sortGodsByOrigin(boolean asc);

	List<God> sortGodsByAlignment(boolean asc);
	
	List<God> sortGodsByDomains(boolean asc);
	
	List<God> sortGodsBySymbol(boolean asc);

	List<String> getAlignments();
}
