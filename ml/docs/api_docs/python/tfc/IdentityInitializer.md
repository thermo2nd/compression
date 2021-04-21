description: Initialize to the identity kernel with the given shape.

<div itemscope itemtype="http://developers.google.com/ReferenceObject">
<meta itemprop="name" content="tfc.IdentityInitializer" />
<meta itemprop="path" content="Stable" />
<meta itemprop="property" content="__call__"/>
<meta itemprop="property" content="__init__"/>
<meta itemprop="property" content="from_config"/>
<meta itemprop="property" content="get_config"/>
</div>

# tfc.IdentityInitializer

<!-- Insert buttons and diff -->

<table class="tfo-notebook-buttons tfo-api nocontent" align="left">
<td>
  <a target="_blank" href="https://github.com/tensorflow/compression/tree/master/tensorflow_compression/python/layers/initializers.py#L25-L55">
    <img src="https://www.tensorflow.org/images/GitHub-Mark-32px.png" />
    View source on GitHub
  </a>
</td>
</table>



Initialize to the identity kernel with the given shape.

<pre class="devsite-click-to-copy prettyprint lang-py tfo-signature-link">
<code>tfc.IdentityInitializer(
    gain=1
)
</code></pre>



<!-- Placeholder for "Used in" -->

This creates an n-D kernel suitable for `SignalConv*` with the requested
support that produces an output identical to its input (except possibly at the
signal boundaries).

Note: The identity initializer in `tf.keras.initializers` is only suitable for
matrices, not for n-D convolution kernels (i.e., no spatial support).

## Methods

<h3 id="from_config"><code>from_config</code></h3>

<pre class="devsite-click-to-copy prettyprint lang-py tfo-signature-link">
<code>@classmethod</code>
<code>from_config(
    config
)
</code></pre>

Instantiates an initializer from a configuration dictionary.


#### Example:



```python
initializer = RandomUniform(-1, 1)
config = initializer.get_config()
initializer = RandomUniform.from_config(config)
```

<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2">Args</th></tr>

<tr>
<td>
`config`
</td>
<td>
A Python dictionary, the output of `get_config`.
</td>
</tr>
</table>



<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2">Returns</th></tr>
<tr class="alt">
<td colspan="2">
A `tf.keras.initializers.Initializer` instance.
</td>
</tr>

</table>



<h3 id="get_config"><code>get_config</code></h3>

<a target="_blank" href="https://github.com/tensorflow/compression/tree/master/tensorflow_compression/python/layers/initializers.py#L52-L55">View source</a>

<pre class="devsite-click-to-copy prettyprint lang-py tfo-signature-link">
<code>get_config()
</code></pre>

Returns the configuration of the initializer as a JSON-serializable dict.


<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2">Returns</th></tr>
<tr class="alt">
<td colspan="2">
A JSON-serializable Python dict.
</td>
</tr>

</table>



<h3 id="__call__"><code>__call__</code></h3>

<a target="_blank" href="https://github.com/tensorflow/compression/tree/master/tensorflow_compression/python/layers/initializers.py#L40-L50">View source</a>

<pre class="devsite-click-to-copy prettyprint lang-py tfo-signature-link">
<code>__call__(
    shape, dtype=None, **kwargs
)
</code></pre>

Returns a tensor object initialized as specified by the initializer.


<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2">Args</th></tr>

<tr>
<td>
`shape`
</td>
<td>
Shape of the tensor.
</td>
</tr><tr>
<td>
`dtype`
</td>
<td>
Optional dtype of the tensor.
</td>
</tr><tr>
<td>
`**kwargs`
</td>
<td>
Additional keyword arguments.
</td>
</tr>
</table>





