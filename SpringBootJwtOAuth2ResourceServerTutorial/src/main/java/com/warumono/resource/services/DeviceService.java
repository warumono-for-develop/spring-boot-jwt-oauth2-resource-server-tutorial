package com.warumono.resource.services;

import org.springframework.stereotype.Service;

import com.warumono.resource.entities.Device;
import com.warumono.resource.repositories.AbstractRepository;

@Service
public class DeviceService extends AbstractService<AbstractRepository<Device>, Device>
{
}
