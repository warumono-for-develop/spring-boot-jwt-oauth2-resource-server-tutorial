package com.warumono.resource.repositories;

import com.warumono.resource.entities.Profile;

public interface ProfileRepository extends AbstractRepository<Profile>
{
	Profile findByUsername(String username);
}
