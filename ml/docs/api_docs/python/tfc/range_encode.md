description: Range encodes integer data with a finite alphabet.

<div itemscope itemtype="http://developers.google.com/ReferenceObject">
<meta itemprop="name" content="tfc.range_encode" />
<meta itemprop="path" content="Stable" />
</div>

# tfc.range_encode

<!-- Insert buttons and diff -->

<table class="tfo-notebook-buttons tfo-api nocontent" align="left">

</table>



Range encodes integer `data` with a finite alphabet.

<pre class="devsite-click-to-copy prettyprint lang-py tfo-signature-link">
<code>tfc.range_encode(
    data, cdf, precision, debug_level=1, name=None
)
</code></pre>



<!-- Placeholder for "Used in" -->

The op uses the provided cumulative distribution functions (CDF) in `cdf`. The
shape of `cdf` should have one more axis than the shape of `data`, and the
prefix `cdf.shape[:-1]` should be broadcastable to `data.shape`. That is, for
every `i = 0,...,rank(data) - 1`, the op requires that either
`cdf.shape[i] == 1` or `cdf.shape[i] == data.shape[i]`. Note that this
broadcasting is limited in the sense that the number of axes must match, and
broadcasts only `cdf` but not `data`.

`data` should have an upper bound `m > 0` such that each element is an integer
in range `[0, m)`. Then the last dimension size of `cdf` must be `m + 1`. For
each element of `data`, the innermost strip of `cdf` is a vector representing a
CDF. For each k = 0,...,m, `cdf[..., k] / 2^precision` is the probability that
an outcome is less than `k` (not less than or equal to).

```
   cdf[..., 0] / 2^precision = Pr(data[...] < 0)
   cdf[..., 1] / 2^precision = Pr(data[...] < 1) = Pr(data[...] <= 0)
   cdf[..., 2] / 2^precision = Pr(data[...] < 2) = Pr(data[...] <= 1)
   ...
   cdf[..., m] / 2^precision = Pr(data[...] < m) = 1
```

Therefore each element of `cdf` must be in `[0, 2^precision]`.

Ideally `cdf[..., m]` should equal to `2^precision` but this is not a hard
requirement as long as `cdf[..., m] <= 2^precision`.

The encoded string neither contains the shape information of the encoded data
nor a termination symbol. Therefore the shape of the encoded data must be
explicitly provided to the decoder.

#### Implementation notes:



- Because of potential performance issues, the op does not check whether
elements of `data` is in the correct range `[0, m)`, or if `cdf` satisfies
monotonic increase property.

- For the range coder to decode the encoded string correctly, the decoder should
be able to reproduce the internal states of the encoder precisely. Otherwise,
the decoding would fail and once an error occur, all subsequent decoded values
are incorrect. For this reason, the range coder uses integer arithmetics and
avoids using any floating point operations internally, and `cdf` should contain
integers representing quantized probability mass rather than floating points.

<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2"><h2 class="add-link">Args</h2></th></tr>

<tr>
<td>
`data`
</td>
<td>
A `Tensor` of type `int16`. An int16 tensor.
</td>
</tr><tr>
<td>
`cdf`
</td>
<td>
A `Tensor` of type `int32`.
An int32 tensor representing the CDF's of `data`. Each integer is divided
by `2^precision` to represent a fraction.
</td>
</tr><tr>
<td>
`precision`
</td>
<td>
An `int` that is `>= 1`.
The number of bits for probability quantization. Must be <= 16.
</td>
</tr><tr>
<td>
`debug_level`
</td>
<td>
An optional `int`. Defaults to `1`. Either 0 or 1.
</td>
</tr><tr>
<td>
`name`
</td>
<td>
A name for the operation (optional).
</td>
</tr>
</table>



<!-- Tabular view -->
 <table class="responsive fixed orange">
<colgroup><col width="214px"><col></colgroup>
<tr><th colspan="2"><h2 class="add-link">Returns</h2></th></tr>
<tr class="alt">
<td colspan="2">
A `Tensor` of type `string`. A range-coded scalar string.
</td>
</tr>

</table>

