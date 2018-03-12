package com.warumono.resource.services;

import org.springframework.stereotype.Service;

import com.warumono.resource.entities.Acceptance;
import com.warumono.resource.repositories.AbstractRepository;

@Service
public class AcceptanceService extends AbstractService<AbstractRepository<Acceptance>, Acceptance>
{
}
