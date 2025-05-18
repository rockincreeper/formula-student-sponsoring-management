package fs.sponsoring.management.budget_manager.infrastructure.persistence;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.SponsorAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsor.sponsoring_package.SponsoringPackage;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringAggregate;
import fs.sponsoring.management.budget_manager.domain.aggregates.sponsoring.SponsoringRepository;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.dto.sponsoring.SponsoringDto;
import fs.sponsoring.management.budget_manager.infrastructure.persistence.mapper.SponsoringMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemorySponsoringRepository implements SponsoringRepository {
    private final String pathToSponsoringFile = "src/main/resources/sponsorings.json";
    private final ObjectMapper mapperForSponsoring = new ObjectMapper();

    private final Map<String, SponsoringAggregate> sponsoringStorage = new HashMap<>();

    public InMemorySponsoringRepository() {
        mapperForSponsoring.registerModule(new JavaTimeModule());
        loadSponsorings();
    }

    private void loadSponsorings() {
        try {
            SponsoringDto[] sponsorings = mapperForSponsoring.readValue(new File(pathToSponsoringFile), SponsoringDto[].class);
            for (SponsoringDto sponsoringDto : sponsorings) {
                SponsoringAggregate sponsoring = SponsoringMapper.toDomain(sponsoringDto);
                sponsoringStorage.put(sponsoring.getId(), sponsoring);
            }
        } catch (StreamReadException e) {
            throw new RuntimeException("Failed to stream sponsorings", e);
        } catch (DatabindException e) {
            throw new RuntimeException("Failed to bind sponsorings", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load sponsorings", e);
        }
    }

    @Override
    public List<SponsoringAggregate> findAllSponsoringsOfTeam() {
        return new ArrayList<>(sponsoringStorage.values());
    }

    @Override
    public List<SponsoringAggregate> findAllSponsoringsForSponsor(String sponsorId) {
        return List.of();
    }

    @Override
    public SponsoringPackage findForSponsorById(String sponsorId) {
        return null;
    }

    @Override
    public void save(SponsoringAggregate sponsoringAggregate) {
        this.sponsoringStorage.put(sponsoringAggregate.getId(), sponsoringAggregate);
        Collection<SponsoringAggregate> sponsorings = sponsoringStorage.values();
        try{
        mapperForSponsoring.writerWithDefaultPrettyPrinter().writeValue(new File(pathToSponsoringFile), sponsorings);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save sponsorings",e);
        }
    }
}
