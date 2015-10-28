package com.uibinder.moradan.shared;

import java.io.Serializable;

/**
 * https://drive.google.com/file/d/0B418nT5Bo9w_engtSTdpVDllY2s/view ( https://github.com/Home-GWT/docs/blob/master/gwt-tutorial-ru.pdf )
 * - Сериализация:
 *   Каждый раз когда вы передаете объект по сети посредством GWT RPC, он нуждается в сериализации. Сериализация это процесс упаковки содержания объекта, так чтобы он мог быть передан из одного приложения в другое или сохранен для последующего использования. GWT RPC требует чтобы все параметры сервисных методов и возвращаемые значения были сериализуемы.
 *   ( Отметим также, что в GWT сериализация и сериализация основанная на Java Serializable interface это не одно и то же )
 * - Требования к сериализации:
 *   Что делает класс сериализуемым? Для начала, все примитивные типы (int, char, boolean, etc.) и их объекты оболочки сериализуемы по умолчанию. Массивы сериализуемых типов также сериализуемы.
 *   Классы сериализуемы если они соответствуют нескольким основным требованиям:
 *   1. Класс реализует IsSerializable или Serializable напрямую или наследуется от суперкласса реализующего эти интерфейсы.
 *   2. Он не является final или transient, объектные поля также сериализуемы и, наконец
 *   3. Он содержит конструктор по умолчанию (без аргументов) с любым модификатором доступа (например private Foo(){} вполне достаточно)
 *   ( GWT уважает ключевое слово transient , так что значения в этих полях не сериализуемы, и не посылаются посредством RPC-вызовов )
 */

@SuppressWarnings("serial")
public class ContactList implements Serializable {
	private String id;
	private String displayName;

	/**
	 * Mandatory for RPC serialization.
	 */
	public ContactList() {}
	public ContactList(String id, String displayName) {
		this.id          = id;
		this.displayName = displayName;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getDisplayName() {
		return displayName;
	}
}
