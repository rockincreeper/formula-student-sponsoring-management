package fs.sponsoring.management.budget_manager.infrastructure.persistence;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.ContactPerson;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorRepository;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsor.SponsorDto;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper.SponsorMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class InMemorySponsorRepository implements SponsorRepository {
    private final String pathToSponsorsFile = "src/main/resources/sponsors.json";
    private final ObjectMapper mapperForSponsors = new ObjectMapper();

    private final Map<String, SponsorAggregate> sponsorsStorage = new HashMap<>();
    private final Map<String, ContactPerson> contactPersonStorage = new HashMap<>();

    public InMemorySponsorRepository() {
        loadSponsors();
    }

    private void loadSponsors() {
        try {
            SponsorDto[] sponsorsDto = mapperForSponsors.readValue(new File(pathToSponsorsFile), SponsorDto[].class);
            for (SponsorDto sponsorDto : sponsorsDto) {
                SponsorAggregate sponsor = SponsorMapper.toDomain(sponsorDto);
                sponsorsStorage.put(sponsor.getId(), sponsor);

            }
        } catch (StreamReadException e) {
            throw new RuntimeException("Failed to stream sponsors", e);
        } catch (DatabindException e) {
            throw new RuntimeException("Failed to bind sponsors", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load sponsors", e);
        }
    }

    private void loadContact() {
    }

    @Override
    public List<SponsorAggregate> findAll() {
        return new ArrayList<>(sponsorsStorage.values());
    }

    @Override
    public SponsorAggregate getSponsorById(String id) {
        return sponsorsStorage.get(id);
    }

    @Override
    public ContactPerson getContactPersonBySponsorId(String sponsorId) {
        return sponsorsStorage.get(sponsorId).getContactPerson();
    }

    @Override
    public SponsoringPackage getSponsoringPackageBySponsorId(String sponsorId) {
        return sponsorsStorage.get(sponsorId).getSponsoringPackage();
    }

    @Override
    public SponsorAggregate save(SponsorAggregate sponsorAggregate) {
        return null;
    }
}
