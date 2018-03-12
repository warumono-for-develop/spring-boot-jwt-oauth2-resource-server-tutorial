package com.warumono.resource.services;

import org.springframework.stereotype.Service;

import com.warumono.resource.entities.Profile;
import com.warumono.resource.repositories.AbstractRepository;

@Service
public class ProfileService extends AbstractService<AbstractRepository<Profile>, Profile>
{
	public void aaa(String identity)
	{
		profile(identity);
	}
	
}
