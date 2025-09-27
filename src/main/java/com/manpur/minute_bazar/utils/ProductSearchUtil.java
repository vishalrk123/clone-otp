package com.manpur.minute_bazar.utils;

import com.manpur.minute_bazar.model.Product;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductSearchUtil {

    // --- Trie Node Definition ---
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        Set<Product> products = new HashSet<>();
    }

    private final TrieNode root = new TrieNode();

    // --- Insert Product into Trie ---
    public void insert(Product product) {
        String name = product.getName().toLowerCase(); // normalize to lowercase
        TrieNode current = root;

        for (char ch : name.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
            current.products.add(product); // keep product for this prefix
        }
    }

    // --- Search by Prefix (case-insensitive) ---
    public Set<Product> search(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return Collections.emptySet();
        }

        String query = prefix.toLowerCase(); // normalize to lowercase
        TrieNode current = root;

        for (char ch : query.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if (node == null) {
                return Collections.emptySet(); // no matches
            }
            current = node;
        }

        return current.products;
    }

    // --- Bulk Insert ---
    public void insertAll(List<Product> products) {
        for (Product product : products) {
            insert(product);
        }
    }
}

