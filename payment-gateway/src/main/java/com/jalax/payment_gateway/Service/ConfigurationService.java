package com.jalax.payment_gateway.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalax.payment_gateway.Entity.Configuration;
import com.jalax.payment_gateway.Repo.ConfigurationRepository;

@Service
public class ConfigurationService {
	
    private final ConfigurationRepository configurationRepository;

    @Autowired
    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public Configuration getConfiguration(String key) throws Exception {
        return configurationRepository.findByKey(key)
                .orElseThrow(() -> new Exception("Configuration not found for key: " + key));
    }

    public Configuration createConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    public Configuration updateConfiguration(String key, Configuration updatedConfiguration) throws Exception {
        Configuration configuration = getConfiguration(key);
        configuration.setValue(updatedConfiguration.getValue());
        configuration.setDescription(updatedConfiguration.getDescription());
        return configurationRepository.save(configuration);
    }

    public void deleteConfiguration(String key) throws Exception {
        Configuration configuration = getConfiguration(key);
        configurationRepository.delete(configuration);
    }
}
