import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SimpleDIContainer {
    private final Map<Class<?>, Class<?>> registry = new HashMap<>();

    public <T, I extends T> void register(Class<T> interfaceType, Class<I> implementationType) {
        registry.put(interfaceType, implementationType);
    }

    @SuppressWarnings("unchecked")
    public <T> T resolve(Class<T> type) {
        // Verifica se o tipo solicitado é uma interface ou classe concreta e obtém a implementação correspondente
        // se não for encontrada, assume que o tipo solicitado é a própria implementação
        Class<?> implementationType = registry.getOrDefault(type, type);

        // Obtém o construtor da classe de implementação (assumindo que há apenas um construtor)
        Constructor<?> constructor = implementationType.getDeclaredConstructors()[0];

        // Obtém os tipos dos parâmetros do construtor
        Class<?>[] parameterTypes = constructor.getParameterTypes();

        // Resolve as dependências recursivamente para cada parâmetro do construtor
        Object[] parameters = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = resolve(parameterTypes[i]);
        }

        try {
            return (T) constructor.newInstance(parameters);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + implementationType.getName(), e);
        }
    }
}
