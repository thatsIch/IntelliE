package de.thatsich.intellie.common.registries;

/**
 All registies need to be able to register their stuff in the end

 @author thatsIch
 @date 25.03.2014. */
public interface IRegistry<T>
{
	void add ( T elem );

	/**
	 Registers that particular part
	 */
	void register ();
}
