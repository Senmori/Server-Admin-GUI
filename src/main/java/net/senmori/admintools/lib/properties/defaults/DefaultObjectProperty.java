package net.senmori.admintools.lib.properties.defaults;

import net.senmori.admintools.lib.properties.event.ChangeEvent;
import net.senmori.admintools.lib.properties.primitive.ObjectProperty;

public class DefaultObjectProperty<T> extends ObjectProperty<T> {
    
    private T defaultValue;
    
    public DefaultObjectProperty(final T value) {
        super(null, null, value);
        this.defaultValue = value;
    }
    
    public DefaultObjectProperty(final T value, final T defaultValue) {
        super(null, null, value);
        this.defaultValue = defaultValue;
    }

    public DefaultObjectProperty(final Object bean, final String name, T value) {
        super(bean, name, value);
        this.defaultValue = value;
    }

    public DefaultObjectProperty(final Object bean, final String name, final T value, final T defaultValue) {
        super(bean, name, value);
        this.defaultValue = defaultValue;
    }

    @Override
    protected void setValue(T value) {
        if (value == null) {
            value = getDefaultValue();
        }
        final T old = this.value;
        this.value = value;
        invalidated();
        fireEvent( new ChangeEvent<>( this, old, this.value ) );
    }

    public T getDefaultValue() {
        return defaultValue;
    }
}