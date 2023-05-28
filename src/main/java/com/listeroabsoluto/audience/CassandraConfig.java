package com.listeroabsoluto.audience;

import java.util.List;

import com.datastax.oss.driver.api.core.config.DefaultDriverOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.DriverConfigLoaderBuilderConfigurer;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.listeroabsoluto")
public class CassandraConfig extends AbstractCassandraConfiguration {

    private final String localDataCenter;
    private final String hosts;
    private final String entityBasePackage;
    private final String keyspace;

    CassandraConfig(
            @Value("${spring.data.cassandra.local-datacenter}") String localDataCenter,
            @Value("${spring.data.cassandra.entity-base-package}") String entityBasePackage,
            @Value("${spring.data.cassandra.contact-points}") String hosts,
            @Value("${spring.data.cassandra.keyspace-name}") String keyspace) {
        this.entityBasePackage = entityBasePackage;
        this.localDataCenter = localDataCenter;
        this.hosts = hosts;
        this.keyspace = keyspace;

    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.RECREATE;
    }

    @Override
    public List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspace)
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .ifNotExists();

        return List.of(specification);
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] { entityBasePackage };
    }

    @Override
    protected String getLocalDataCenter() {
        return localDataCenter;
    }

    @Override
    protected String getContactPoints() {
        return hosts;
    }

    @Override
    protected DriverConfigLoaderBuilderConfigurer getDriverConfigLoaderBuilderConfigurer()
    {
        return config ->
                config
                        .withString(DefaultDriverOption.METADATA_SCHEMA_REQUEST_TIMEOUT, "30s")
                        .withString(DefaultDriverOption.CONTROL_CONNECTION_TIMEOUT, "10s")
                        .withString(DefaultDriverOption.REQUEST_TIMEOUT, "30s")
                        .build();
    }
}