package com.srs.common.mapper;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author duynt on 2/13/22
 */
public abstract class BaseMapper {
    protected final ModelMapper modelMapper = new ModelMapper();

    @PostConstruct
    private void configModelMapper() {
        var stringNullConverter = new Converter<String, String>() {
            public String convert(MappingContext<String, String> context) {
                return ObjectUtils.defaultIfNull(context.getSource(), "");
            }
        };
        var integerNullConverter = new Converter<Integer, Integer>() {
            public Integer convert(MappingContext<Integer, Integer> context) {
                return ObjectUtils.defaultIfNull(context.getSource(), -1);
            }
        };
        var longNullConverter = new Converter<Long, Long>() {
            public Long convert(MappingContext<Long, Long> context) {
                return ObjectUtils.defaultIfNull(context.getSource(), -1L);
            }
        };
        var booleanNullConverter = new Converter<Boolean, Boolean>() {
            public Boolean convert(MappingContext<Boolean, Boolean> context) {
                return ObjectUtils.defaultIfNull(context.getSource(), false);
            }
        };
        var floatNullConverter = new Converter<Float, Float>() {
            @Override
            public Float convert(MappingContext<Float, Float> context) {
                return Objects.requireNonNullElse(context.getSource(), -1.0f);
            }
        };
        this.modelMapper.addConverter(stringNullConverter);
        this.modelMapper.addConverter(integerNullConverter);
        this.modelMapper.addConverter(longNullConverter);
        this.modelMapper.addConverter(booleanNullConverter);
        this.modelMapper.addConverter(floatNullConverter);

        this.modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param <S>         {@code source} type
     * @param <D>         {@code destination} type
     * @param source      object to map from
     * @param destination object to map to
     */
    public <D, S> D map(final S source, D destination) {
        if (Objects.isNull(source)) {
            return null;
        }
        modelMapper.map(source, destination);
        return destination;
    }

    /**
     * Maps {@code source} to {@code destination}.
     * <p>
     * Note: {@code destination} object must have default constructor with no arguments
     * </p>
     *
     * @param <S>             {@code source} type
     * @param <D>             {@code destination} type
     * @param source          object to map from
     * @param destinationType type to map to
     * @return new object of {@code destination} type.
     */
    public <D, S> D map(final S source, Class<D> destinationType) {
        return Objects.isNull(source)
                ? null
                : modelMapper.map(source, destinationType);
    }

    /**
     * <p>
     * map {@code list of element} from {@code Collection<S> sourceList} into list of mapped object
     * with {@code D} type by iterating the {@code sourceList}
     * </p>
     *
     * @param sourceList      list of object to map from
     * @param destinationType type to map to
     * @param <D>             destination type
     * @param <S>             {@code sourceList} type
     * @return list of mapped object with {@code D} type.
     */
    public <D, S> List<D> map(final Collection<S> sourceList, Class<D> destinationType) {
        return Objects.isNull(sourceList)
                ? null
                : sourceList.parallelStream().map(source -> this.map(source, destinationType))
                .collect(Collectors.toList());
    }

    /**
     * <p>
     * map {@code list of element} from {@code Collection<S> sourceList} into list of mapped object
     * with {@code D} type by {@link TypeToken}
     * </p>
     *
     * @param sourceList list of object to map from
     * @param <D>        destination type
     * @param <S>        {@code sourceList} type
     * @return list of mapped object with {@code D} type.
     */
    public <D, S> List<D> map(final Collection<S> sourceList) {
        return modelMapper.map(sourceList, new TypeToken<List<D>>() {
        }.getType());
    }
}
