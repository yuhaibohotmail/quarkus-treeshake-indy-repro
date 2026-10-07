package org.acme.lib;

// Only referenced from the invokedynamic call site in Selector (its NameAndType descriptor
// is ()Lorg/acme/lib/Tagged;). No other bytecode mentions this class.
interface Tagged extends Selector {
}
