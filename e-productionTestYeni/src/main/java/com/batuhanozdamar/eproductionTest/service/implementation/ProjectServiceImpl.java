package com.batuhanozdamar.eproductionTest.service.implementation;

import com.batuhanozdamar.eproductionTest.Entity.Project;
import com.batuhanozdamar.eproductionTest.Entity.User;
import com.batuhanozdamar.eproductionTest.dto.ProjectDto;
import com.batuhanozdamar.eproductionTest.repository.ProjectRepository;
import com.batuhanozdamar.eproductionTest.service.ProjectService;
import com.batuhanozdamar.eproductionTest.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final com.batuhanozdamar.eproductionTest.repository.userRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, com.batuhanozdamar.eproductionTest.repository.userRepository userRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.userRepository= userRepository;
    }

    @Override
    public ProjectDto save(ProjectDto project) {

        Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());

        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        Project p = modelMapper.map(project, Project.class);
        User user = userRepository.getOne(project.getManagerId());
        p.setManager(user);

        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {
        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> respnose = new TPage<ProjectDto>();
        respnose.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
        return respnose;
    }

    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }

    public List<ProjectDto> getAll() {
        List<Project> data = projectRepository.findAll();
        return Arrays.asList(modelMapper.map(data, ProjectDto[].class));
    }
}
