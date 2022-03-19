package com.extendedDnD.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.extendedDnD.locator.GodsLocator;
import com.extendedDnD.model.God;

@Service
public class GodsServiceImpl implements GodsService {

	private List<God> formatGods() {
		List<God> gods = new ArrayList<>();
		String[][] deities = GodsLocator.getItems().map(t->t.getAppendix().getPantheon().getTable().getDeities()).findFirst().orElse(null);
		String[] origin = {"Celtic", "Greek", "Egyptian", "Norse"};
		String[][] alignment = GodsLocator.getItems().map(t->t.getAppendix().getPantheon().getTable().getAlignment()).findFirst().orElse(null);
		String[][] domains = GodsLocator.getItems().map(t->t.getAppendix().getPantheon().getTable().getDomains()).findFirst().orElse(null);
		String[][] symbol = GodsLocator.getItems().map(t->t.getAppendix().getPantheon().getTable().getSymbol()).findFirst().orElse(null);
		
		for (int x = 0; x<deities.length; x++) {
			for (int y = 0; y<deities[x].length; y++) {
				gods.add(new God(deities[x][y], origin[x], alignment[x][y], domains[x][y], symbol[x][y]));
			}
		}
		return gods;
	}
	
	@Override
	public List<God> getGods() {
		return formatGods();
	}
	
	@Override
	public String[] getPantheonContent() {
		return GodsLocator.getItems().map(t->t.getAppendix().getPantheon().getContentPantheon()).findFirst().orElse(null);
	}
	
	@Override
	public String getAppendixContent() {
		return GodsLocator.getItems().map(t->t.getAppendix().getContentAppendix()).findFirst().orElse(null);
	}
	
	@Override
	public List<String> getAlignments() {
		return formatGods().stream().map(God::getAlignment).distinct().collect(Collectors.toList());
	}
	
	@Override
	public List<God> getGodsByOrigin(String origin) {
		return formatGods().stream().filter(t->t.getOrigin().equals(origin)).collect(Collectors.toList());
	}
	
	@Override
	public List<God> getGodsByAlignment(String alignment) {
		return formatGods().stream().filter(t->t.getAlignment().toLowerCase().equals(alignment.toLowerCase())).collect(Collectors.toList());
	}
	
	@Override
	public List<God> sortGodsByDeity(boolean asc) {
		if (asc) {
			return formatGods().stream().sorted(Comparator.comparing(God::getDeity)).collect(Collectors.toList());
		}
		return formatGods().stream().sorted(Comparator.comparing(God::getDeity).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<God> sortGodsByOrigin(boolean asc) {
		if (asc) {
			return formatGods().stream().sorted(Comparator.comparing(God::getOrigin)).collect(Collectors.toList());
		}
		return formatGods().stream().sorted(Comparator.comparing(God::getOrigin).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<God> sortGodsByAlignment(boolean asc) {
		if (asc) {
			return formatGods().stream().sorted(Comparator.comparing(God::getAlignment)).collect(Collectors.toList());
		}
		return formatGods().stream().sorted(Comparator.comparing(God::getAlignment).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<God> sortGodsByDomains(boolean asc) {
		if (asc) {
			return formatGods().stream().sorted(Comparator.comparing(God::getDomains)).collect(Collectors.toList());
		}
		return formatGods().stream().sorted(Comparator.comparing(God::getDomains).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<God> sortGodsBySymbol(boolean asc) {
		if (asc) {
			return formatGods().stream().sorted(Comparator.comparing(God::getSymbol)).collect(Collectors.toList());
		}
		return formatGods().stream().sorted(Comparator.comparing(God::getSymbol).reversed()).collect(Collectors.toList());
	}
}
