package ru.bellintegrator.practice.docs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.docs.dao.DocDao;
import ru.bellintegrator.practice.docs.model.Doc;
import ru.bellintegrator.practice.docs.view.DocView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class DocServiceImpl implements DocService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DocDao dao;

    @Autowired
    public DocServiceImpl(DocDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(DocView view) {
        Doc doc = new Doc(view.name, view.code);
        dao.save(doc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<DocView> docs() {
        List<Doc> all = dao.all();

        return all.stream()
                .map(mapDoc())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public DocView loadById(int id){
        DocView view = new DocView();
        Doc doc = dao.loadById(id);
        view.code = doc.getCode();
        view.name = doc.getName();
        view.id = doc.getId();
        return view;
    }

    private Function<Doc, DocView> mapDoc() {
        return p -> {
            DocView view = new DocView();
            view.id = p.getId();
            view.name = p.getName();
            view.code = p.getCode();

            log.debug(view.toString());

            return view;
        };
    }
}
